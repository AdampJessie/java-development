package com.pluralsight.NorthwindTradersAPI.dao.impl;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.ICategoryDAO;
import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCategoryDAO implements ICategoryDAO {

    private DataSource dataSource;

    @Autowired
    public JdbcCategoryDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        // This method retrieves all categories from the database.
        List<Category> categories = new ArrayList<>();
        String getAllQuery = "SELECT * FROM categories";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                // Extract data from each row in the result set.
                int categoryIdFromDb = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("CategoryName");
                // Create a Category object and add it to the list.
                categories.add(new Category(categoryIdFromDb, categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return categories; // Return the list of categories.
    }

    @Override
    public Category getCategoryById(int categoryId) {
        // This method retrieves a specific category by its ID.
        Category category = null;
        String getByIdQuery = "SELECT * FROM categories WHERE category_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getByIdQuery)) {
            selectStatement.setInt(1, categoryId); // Set the ID parameter in the query.
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract data from the result set.
                    int categoryIdFromDb = resultSet.getInt("category_id");
                    String categoryName = resultSet.getString("CategoryName");
                    // Create a Category object.
                    category = new Category(categoryId, categoryName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return category; // Return the found category or null.
    }

}
