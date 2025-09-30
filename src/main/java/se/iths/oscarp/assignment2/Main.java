package se.iths.oscarp.assignment2;

import se.iths.oscarp.assignment2.model.Application;
import se.iths.oscarp.assignment2.model.ProductDao;
import se.iths.oscarp.assignment2.model.ScannerUI;

public class Main {
    public static void main(String[] args) {
        ProductDao proDao = new ProductDao();
        ScannerUI scannerUi = new ScannerUI();
        Application app = new Application(proDao, scannerUi);
        boolean start = true;

        while (start) {
            app.startApplication();
            start = false;
        }

    }
}
