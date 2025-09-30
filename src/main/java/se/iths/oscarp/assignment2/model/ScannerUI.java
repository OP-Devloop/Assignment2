package se.iths.oscarp.assignment2.model;

import java.util.Scanner;

public class ScannerUI implements UI {
    private Scanner input = new Scanner(System.in);

    @Override
    public Integer menu() {
        System.out.println("""
                1: Show All Products
                2: Add Product
                3: Search Product
                4: Exit""");

        return input.nextInt();
    }

    @Override
    public void question(String question) {
        System.out.println(question);
    }

    @Override
    public void error(String error) {
        System.err.println(error);
    }
}
