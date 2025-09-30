package se.iths.oscarp.assignment2.model;

import java.util.List;

public interface ProductUI {

    public List<Product> getAllProducts();

    public void addProduct(Product product);

    public Product findProductById(int articleNumber);
}
