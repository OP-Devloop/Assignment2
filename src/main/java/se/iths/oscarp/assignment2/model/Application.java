package se.iths.oscarp.assignment2.model;

import java.util.Scanner;

public class Application {
    private Scanner sc = new Scanner(System.in);
    private ProductDao productDao;
    private ScannerUI scannerUi;


    public Application(ProductDao productDao, ScannerUI scannerUi) {
        this.productDao = productDao;
        this.scannerUi = scannerUi;
    }

    public void startApplication() {

        boolean onOff = true;
        while (onOff) {

            int choice = scannerUi.menu();

            switch (choice) {
                case 1 -> printAllProducts();
                case 2 -> addProduct();
                case 3 -> findProduct();
                case 4 -> {
                    System.out.println("Exiting Application...");
                    onOff = false;
                }
            }
        }
    }

    public void printAllProducts() {
        for (Product p : productDao.getAllProducts()) {
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
                scannerUi.question("Input article number");
                int articleNumber = sc.nextInt();
                sc.nextLine();

                scannerUi.question("Input product name");
                String productName = sc.nextLine();

                scannerUi.question("Input product price");
                double productPrice = sc.nextDouble();
                sc.nextLine();

                scannerUi.question("Input product description");
                String productDescription = sc.nextLine();

                Product newBook = new Book(articleNumber, productName, productPrice, productDescription);
                productDao.addProduct(newBook);
            }
            case "electronics" -> {
                scannerUi.question("Input article number");
                int articleNumber = sc.nextInt();
                sc.nextLine();

                scannerUi.question("Input product name");
                String productName = sc.nextLine();

                scannerUi.question("Input product price");
                double productPrice = sc.nextDouble();
                sc.nextLine();

                scannerUi.question("Input product description");
                String productDescription = sc.nextLine();

                Product newElectronic = new Electronic(articleNumber, productName, productPrice, productDescription);
                productDao.addProduct(newElectronic);
            }
            case "tools" -> {
                scannerUi.question("Input article number");
                int articleNumber = sc.nextInt();
                sc.nextLine();

                scannerUi.question("Input product name");
                String productName = sc.nextLine();

                scannerUi.question("Input product price");
                double productPrice = sc.nextDouble();
                sc.nextLine();

                scannerUi.question("Input product description");
                String productDescription = sc.nextLine();

                Product newTool = new Tool(articleNumber, productName, productPrice, productDescription);
                productDao.addProduct(newTool);
            }
            default -> scannerUi.error("Invalid choice.");
        }
    }

    public void findProduct() {
        System.out.println("Enter product number");
        int id = sc.nextInt();
        sc.nextLine();
        Product productID = productDao.findProductById(id);
        if (productID != null) {
            System.out.println("Product found: ");
            System.out.println(productID);
            productID.category();
        } else {
            System.out.println("Product not found");
        }
    }
}
