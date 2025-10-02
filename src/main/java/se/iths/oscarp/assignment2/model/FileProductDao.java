package se.iths.oscarp.assignment2.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileProductDao implements ProductUI {
    private List<Product> products = new ArrayList<>();

    public void loadFromFile(Path path) {
        products.clear();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] parts = line.split(";", 5);
                if (parts.length < 5) continue;

                String type = parts[0].trim().toLowerCase();
                int articleNumber = Integer.parseInt(parts[1].trim());
                String name = parts[2].trim();
                String priceStr = parts[3].trim().replace(",", ".");
                double price = Double.parseDouble(priceStr);
                String description = parts[4].trim();

                Product product = switch (type) {
                    case "book" -> new Book(articleNumber, name, price, description);
                    case "electronic" -> new Electronic(articleNumber, name, price, description);
                    case "tool" -> new Tool(articleNumber, name, price, description);
                    default -> null;
                };
                if (product != null) products.add(product);
            }
            System.out.println("Loaded " + products.size() + " products from file");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveToFile(Path path) {
        products.sort(Comparator.comparingInt(Product::getArticleNumber));

        List<String> lines = new ArrayList<>();
        for (Product p : products) {
            String type = p.getClass().getSimpleName().toLowerCase();
            lines.add(String.format("%s; %d; %s; %.2f; %s",
                    type,
                    p.getArticleNumber(),
                    p.getName(),
                    p.getPrice(),
                    p.getDescription()));
        }

        try {
            Files.write(path, lines);
            System.out.println("Saved products to file");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public void ensureFileExists(Path path) {
        try {
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creating file or directories", e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void addProduct(Product product) {
        if (findProductById(product.getArticleNumber()) != null) {
            System.err.println("Product with this article number already exists");
            return;
        }
        products.add(product);
    }

    @Override
    public Product findProductById(int articleNumber) {
        for (Product p : products) {
            if (p.getArticleNumber() == articleNumber) return p;
        }
        return null;
    }
}
