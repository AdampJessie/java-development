
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("This application needs a Username and a Password to run");
                System.exit(1);
            }

            String username = args[0];
            String password = args[1];

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password
            );

            String query = """
                    SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                    FROM products
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet results = preparedStatement.executeQuery();

            while (results.next()) {

                String productID = results.getString("ProductID");
                String productName = results.getString("ProductName");
                String unitPrice = results.getString("UnitPrice");
                String unitsInStock = results.getString("UnitsInStock");

                System.out.println("Product ID: " + productID);
                System.out.println("Product Name: " + productName);
                System.out.println("Product Price: " + unitPrice);
                System.out.println("Units in Stock: " + unitsInStock);
                System.out.println("==============================================");
            }

            results.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            System.out.println("An error has occurred");
            ex.printStackTrace();
        }
    }
}