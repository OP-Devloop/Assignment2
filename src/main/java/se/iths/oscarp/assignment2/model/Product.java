package se.iths.oscarp.assignment2.model;

public abstract class Product {
    private int articleNumber;
    private String name;
    private double price;
    private String description;

    public Product(int articleNumber, String name, double price, String description) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public abstract void category();

    @Override
    public String toString() {
        return String.format("Article #%d: %s\nPrice: $%.2f\nDescription: %s",
                getArticleNumber(), getName(), getPrice(), getDescription());
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
