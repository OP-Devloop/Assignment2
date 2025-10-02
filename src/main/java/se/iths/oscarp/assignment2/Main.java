package se.iths.oscarp.assignment2;

import se.iths.oscarp.assignment2.model.Application;
import se.iths.oscarp.assignment2.model.FileProductDao;
import se.iths.oscarp.assignment2.model.ScannerUI;

public class Main {
    public static void main(String[] args) {
//        ProductDao proDao = new ProductDao();
        FileProductDao fileProDao = new FileProductDao();

        ScannerUI scannerUi = new ScannerUI();
        Application app = new Application(fileProDao, scannerUi);

        app.startApplication();


    }
}