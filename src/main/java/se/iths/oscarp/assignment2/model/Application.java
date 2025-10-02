package se.iths.oscarp.assignment2.model;

import java.nio.file.Path;
import java.util.Scanner;

public class Application {
    private Scanner sc = new Scanner(System.in);
    private ProductDao productDao;
    private FileProductDao fileProDao;
    private ScannerUI scannerUi;
    private ProductInput productInput;

    Path productFile = Path.of("data/products.txt");

    public Application(FileProductDao fileProDao, ScannerUI scannerUi) {
        this.fileProDao = fileProDao;
        this.scannerUi = scannerUi;
    }

    public void startApplication() {
        fileProDao.ensureFileExists(productFile);
        fileProDao.loadFromFile(productFile);

        boolean onOff = true;
        while (onOff) {

            int choice = scannerUi.menu();

            switch (choice) {
                case 1 -> printAllProducts();
                case 2 -> addProduct();
                case 3 -> findProduct();
                case 4 -> {
                    System.out.println("Exiting Application...");
                    fileProDao.saveToFile(productFile);
                    onOff = false;
                }
                default -> scannerUi.error("Invalid choice");
            }
        }
    }

    public void printAllProducts() {
        for (Product p : fileProDao.getAllProducts()) {
            System.out.println(p);
            p.category();
            System.out.println();
        }
    }

    public void addProduct() {
        scannerUi.question("What kind of product do you want to add?");
        scannerUi.question("Books, Electronics or Tools");

        String type = sc.nextLine().trim().toLowerCase();

        switch (type) {
            case "books" -> {
                ProductInput input = makeProductQuestions();
                Product newBook = new Book(input.articleNumber, input.productName,
                        input.productPrice, input.productDescription);

                fileProDao.addProduct(newBook);
                fileProDao.saveToFile(productFile);
            }
            case "electronics" -> {
                ProductInput input = makeProductQuestions();
                Product newElectronic = new Electronic(input.articleNumber, input.productName,
                        input.productPrice, input.productDescription);

                fileProDao.addProduct(newElectronic);
                fileProDao.saveToFile(productFile);
            }
            case "tools" -> {
                ProductInput input = makeProductQuestions();
                Product newTool = new Tool(input.articleNumber, input.productName,
                        input.productPrice, input.productDescription);

                fileProDao.addProduct(newTool);
                fileProDao.saveToFile(productFile);
            }
            default -> scannerUi.error("Invalid choice.");
        }
    }

    public void findProduct() {
        scannerUi.question("Enter product number");
        int id = sc.nextInt();
        sc.nextLine();
        Product productID = fileProDao.findProductById(id);
        if (productID != null) {
            System.out.println("Product found: ");
            System.out.println(productID);
            productID.category();
        } else {
            scannerUi.error("Product not found");
        }
    }

    private ProductInput makeProductQuestions() {
        scannerUi.question("Input article number");
        int articleNumber = sc.nextInt();
        sc.nextLine();

        scannerUi.question("Input product name");
        String productName = sc.nextLine();

        scannerUi.question("Input product price");
        String stringPrice = sc.nextLine();
        double productPrice = Double.parseDouble(stringPrice);

        scannerUi.question("Input product description");
        String productDescription = sc.nextLine();

        return new ProductInput(articleNumber, productName, productPrice, productDescription);
    }
}
