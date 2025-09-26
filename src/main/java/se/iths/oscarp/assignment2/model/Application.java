package se.iths.oscarp.assignment2.model;

import java.util.Scanner;

public class Application {
    private Scanner sc = new Scanner(System.in);
    private ProductDao productDao;
    private UI ui;


    public Application(ProductDao productDao, UI ui) {
        this.productDao = productDao;
        this.ui = ui;
    }

    public void startApplication() {
        ProductDao productDao = new ProductDao();

        boolean onOff = true;
        while (onOff) {

            int choice = ui.menu();

            switch (choice) {
                case 1 -> printAllProducts(productDao);
                case 2 -> addProduct();
                case 3 -> findProduct();
                case 4 -> {
                    System.out.println("Exiting Application...");
                    onOff = false;
                }
            }
        }
    }

    public void printAllProducts(ProductDao productDao) {
        for (Product p : productDao.getAllProducts()) {
            System.out.println(p);
            p.category();
            System.out.println();
        }
    }

    public void addProduct() {
        ui.question("Add Product");
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
