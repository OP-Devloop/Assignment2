package se.iths.oscarp.assignment2;

import se.iths.oscarp.assignment2.model.Application;
import se.iths.oscarp.assignment2.model.ProductDao;
import se.iths.oscarp.assignment2.model.UI;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProductDao proDao = new ProductDao();
        UI ui = new UI();
        Application app = new Application(proDao, ui);
        boolean start = true;

        while (start) {
            app.startApplication();
            start = false;
        }

    }
}
