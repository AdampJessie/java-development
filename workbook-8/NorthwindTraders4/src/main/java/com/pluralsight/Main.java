
package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Check for command line arguments for username and password
        if (args.length != 2) {
            System.out.println("Application needs two arguments to run: " +
                    "java com.pluralsight.Main <username> <password>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        Scanner scanner = new Scanner(System.in);
        boolean selecting = true;
        while (selecting) {
            System.out.println("What do you want to do?");
            System.out.println("1) Display all products");
            System.out.println("2) Display all customers");
            System.out.println("3) Display all categories");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllProducts(username, password);
                    selecting = false;
                    break;
                case 2:
                    displayAllCustomers(username, password);
                    selecting = false;
                    break;
                case 3:
                    displayAllCategories(username, password);
                    selecting = false;
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayAllProducts(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            try (
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind", username, password);

                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products")
            ) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    int productId = results.getInt("ProductID");
                    String productName = results.getString("ProductName");
                    double unitPrice = results.getDouble("UnitPrice");
                    int unitsInStock = results.getInt("UnitsInStock");

                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Unit Price: " + unitPrice);
                    System.out.println("Units In Stock: " + unitsInStock);
                    System.out.println("-----------------------------------------");
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Something went wrong!\n" + e);
        }
    }

    private static void displayAllCustomers(String username, String password) {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind", username, password);
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT ContactName, CompanyName, City, Country, Phone FROM Customers ORDER BY Country"
                    )
            ) {

                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    String contactName = results.getString("ContactName");
                    String companyName = results.getString("CompanyName");
                    String city = results.getString("City");
                    String country = results.getString("Country");
                    String phone = results.getString("Phone");

                    System.out.println("Contact Name: " + contactName);
                    System.out.println("Company Name: " + companyName);
                    System.out.println("City: " + city);
                    System.out.println("Country: " + country);
                    System.out.println("Phone: " + phone);
                    System.out.println("-----------------------------------------");
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Something went wrong!\n" + e);
        }
    }

    private static void displayAllCategories(String username, String password) {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind", username, password);
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT CategoryID, CategoryName FROM Categories"
                    )
            ) {

                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    int categoryID = results.getInt("CategoryID");
                    String categoryName = results.getString("CategoryName");

                    System.out.println("Category ID: " + categoryID);
                    System.out.println("Category Name: " + categoryName);
                    System.out.println("-----------------------------------------");

                }
                selectCategory(username, password);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Something went wrong!\n" + e);
        }
    }

    private static void selectCategory(String username, String password) {

        try {
            int searchID = 0;
            Scanner scanner = new Scanner(System.in);

            boolean selecting = true;
            while (selecting) {
                System.out.print("Please select a category (1-8): ");
                searchID = Integer.parseInt(scanner.nextLine());

                if (searchID >= 0 && searchID <= 8) {
                    scanner.close();
                    selecting = false;
                } else {
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("-----------------------------------------");
                }

            }

            try (
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/northwind", username, password);
                    PreparedStatement statement = connection.prepareStatement(
                            "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products " +
                                    "WHERE CategoryID =" + searchID
                    )

            ) {

                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    int productId = results.getInt("ProductID");
                    String productName = results.getString("ProductName");
                    double unitPrice = results.getDouble("UnitPrice");
                    int unitsInStock = results.getInt("UnitsInStock");

                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Unit Price: " + unitPrice);
                    System.out.println("Units In Stock: " + unitsInStock);
                    System.out.println("-----------------------------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e);
        }

    }
}

