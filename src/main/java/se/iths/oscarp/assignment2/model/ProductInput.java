package se.iths.oscarp.assignment2.model;

public class ProductInput {
    int articleNumber;
    String productName;
    double productPrice;
    String productDescription;

    public ProductInput(int articleNumber, String productName, double productPrice, String productDescription) {
        this.articleNumber = articleNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }
}
