package se.iths.oscarp.assignment2.model;

public class Book extends Product {

    public Book(int articleNumber, String name, double price, String description) {
        super(articleNumber, name, price, description);
    }

    @Override
    public void category() {
        System.out.println("Category: Books");
    }
}
