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

//            System.out.println("""
//                    1: Show All Products
//                    2: Add Product
//                    3: Search Product
//                    4: Exit""");
//
//            int choice = sc.nextInt();
//            sc.nextLine();
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
        ProductDao proDao = new ProductDao();
        UI ui = new UI();
        ui.question("Add Product");
//        System.out.println("Enter Product Name: ");
//        System.out.println("Enter Product Name: ");
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
