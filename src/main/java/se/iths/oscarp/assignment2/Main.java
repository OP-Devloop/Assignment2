package se.iths.oscarp.assignment2;

import se.iths.oscarp.assignment2.model.Application;
import se.iths.oscarp.assignment2.model.ProductDao;
import se.iths.oscarp.assignment2.model.UI;

public class Main {
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
