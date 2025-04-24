package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StoreApp {
    public static void main(String[] args) {
        List<Product> inventory = getInventory();
        listAllProduct(inventory);
    }

    public static List<Product> getInventory() {

        List<Product> inventory = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split("\\|");
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double price = Double.parseDouble(tokens[2]);
                    inventory.add(new Product(id, name, price));
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return inventory;

    }
    public static void listAllProduct(List<Product> productsList){
        System.out.println("We carry the following inventory:");
        System.out.println("-".repeat(40)); // Divider
        for (Product product : productsList) {
            System.out.println(product.toString());
        }
    }
}
