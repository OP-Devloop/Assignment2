package se.iths.oscarp.assignment2.model;

import java.util.Scanner;

public class UI {
    private Scanner input = new Scanner(System.in);

    public Integer menu() {
        System.out.println("""
                1: Show All Products
                2: Add Product
                3: Search Product
                4: Exit""");

        return input.nextInt();
    }

    public void question(String question) {
        System.out.println(question);
    }

    public void error(String error) {
        System.out.println(error);
    }
}
