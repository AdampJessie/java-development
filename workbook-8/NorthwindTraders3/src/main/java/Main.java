
import java.net.ConnectException;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length != 2) {
            System.out.println("This application needs a Username and a Password to run");
            scanner.close();
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];


        boolean selecting = true;
        while (selecting) {
            System.out.println("1) Display all products");
            System.out.println("2) Display all customers");
            System.out.println("0) Exit");
            System.out.println("Please enter a choice:");
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    searchData(username, password, true);
                    break;
                case 2:
                    searchData(username, password, false);
                    break;
                case 0:
                    System.out.println("Exiting!");
                    scanner.close();
                    selecting = false;
                    break;

            }


        }


    }


    public static void searchData(String username, String password, boolean isProduct) {
        ResultSet results = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password
            );

            String query = null;
            if (isProduct) {
                query = """
                        SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                        FROM products
                        """;
            } else query = """
                    SELECT ContactName, CompanyName, City, Country, Phone
                    FROM customers
                    """;

            preparedStatement = connection.prepareStatement(query);

            results = preparedStatement.executeQuery();

            while (results.next()) {
                if (isProduct) {
                    int productID = results.getInt("ProductID");
                    String productName = results.getString("ProductName");
                    double unitPrice = results.getDouble("UnitPrice");
                    String unitsInStock = results.getString("UnitsInStock");

                    System.out.println("Product ID: " + productID);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Product Price: " + unitPrice);
                    System.out.println("Units in Stock: " + unitsInStock);
                    System.out.println("==============================================");
                } else {
                    String contactName = results.getString("ContactName");
                    String companyName = results.getString("CompanyName");
                    String city = results.getString("City");
                    String country = results.getString("Country");
                    String phone = results.getString("Phone");

                    System.out.println("ContactName: " + contactName);
                    System.out.println("CompanyName: " + companyName);
                    System.out.println("City Price: " + city);
                    System.out.println("Country: " + country);
                    System.out.println("Phone: " + phone);
                    System.out.println("==============================================");
                }
            }


        } catch (Exception ex) {
            System.out.println("Error!\n" + ex);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    System.out.println("Error!\n" + e);
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("Error!\n" + e);
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println("Error!\n" + e);
                    }

                }
            }
        }
    }
}