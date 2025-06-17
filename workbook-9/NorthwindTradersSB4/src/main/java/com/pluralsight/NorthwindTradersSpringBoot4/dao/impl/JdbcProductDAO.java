package com.pluralsight.NorthwindTradersSpringBoot4.dao.impl;

import com.pluralsight.NorthwindTradersSpringBoot4.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot4.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements IProductDAO {

    private DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        }

    @Override
    public Product insert(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        // This method retrieves all products from the database.
        List<Product> products = new ArrayList<>();
        String getAllProductsQuery = "SELECT * FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getAllProductsQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                // Extract data from each row in the result set.
                String name = resultSet.getString("productid");
                int categoryId = resultSet.getInt("categoryId");
                double price = resultSet.getDouble("unitPrice");
                // Create a Product object and add it to the list.
                products.add(new Product(name, categoryId, price));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return products; // Return the list of products.;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public void update(int productId, Product product) {

    }

    @Override
    public void delete(int productId) {

    }
}
