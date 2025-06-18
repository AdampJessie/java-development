package com.pluralsight.NorthwindTradersAPI.dao.impl;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAO implements IProductDAO {

    private DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts() {
        // This method retrieves all products from the database.
        List<Product> products = new ArrayList<>();
        String getAllQuery = "SELECT * FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                // Extract data from each row in the result set.
                int productIdFromDb = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                int categoryId = resultSet.getInt("CategoryID");
                double unitPrice = resultSet.getDouble("UnitPrice");


                // Create a Product object and add it to the list.
                products.add(new Product(productIdFromDb, productName, categoryId, unitPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return products; // Return the list of products.
    }

    @Override
    public Product getProductById(int productId) {
        // This method retrieves a specific product by its ID.
        Product product = null;
        String getByIdQuery = "SELECT * FROM products WHERE productid = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)) {
            selectStatement.setInt(1, productId); // Set the ID parameter in the query.
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    int productIdFromDb = resultSet.getInt("ProductID");
                    String productName = resultSet.getString("ProductName");
                    int categoryId = resultSet.getInt("CategoryID");
                    double unitPrice = resultSet.getDouble("UnitPrice");

                    product = new Product(productIdFromDb, productName, categoryId, unitPrice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return product; // Return the found product or null.
    }

    @Override
    public Product add(Product product) {
        String sql = "INSERT INTO Products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryId());
            statement.setDouble(3, product.getUnitPrice());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    product.setProductId(generatedId);
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }


}
