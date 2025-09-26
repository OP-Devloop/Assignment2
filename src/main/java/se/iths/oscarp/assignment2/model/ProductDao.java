package se.iths.oscarp.assignment2.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> products;

    public ProductDao() {
        this.products = new ArrayList<>();

        products.add(new Book(101, "IT",
                29.99, "A book about a clown"));
        products.add(new Book(102, "Dune",
                74.99, "A book about spice"));
        products.add(new Book(103, "Harry Potter",
                49.99, "A book about wizards"));

        products.add(new Electronic(201, "Headphones",
                399.99, "Bluetooth headphones"));
        products.add(new Electronic(202, "Laptop",
                1499.99, "A powerful laptop"));
        products.add(new Electronic(203, "Mouse",
                199.99, "Wireless mouse"));

        products.add(new Tool(301, "Hammer",
                19.99, "A normal hammer"));
        products.add(new Tool(302, "Saw",
                29.99, "A hand saw"));
        products.add(new Tool(303, "Knife",
                24.99, "Utility knife"));
    }

    public ProductDao(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public Product findProductById(int articleNumber) {
        for (Product product : products) {
            if (product.getArticleNumber() == articleNumber) {
                return product;
            }
        }
        return null;
    }

}
