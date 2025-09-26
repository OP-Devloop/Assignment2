package se.iths.oscarp.assignment2;

public class Electronic extends Product {

    public Electronic(int articleNumber, String name, double price, String description) {
        super(articleNumber, name, price, description);
    }

    @Override
    public void category() {
        System.out.println("Category: Electronics");
    }
}
