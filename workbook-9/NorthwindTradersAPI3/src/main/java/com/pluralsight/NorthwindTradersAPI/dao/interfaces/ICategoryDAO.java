package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.model.Category;

import java.util.List;

public interface ICategoryDAO {


/**
 * Interface for Data Access Object (DAO) operations related to the Category model.
 * This interface defines the standard operations to be performed on the Category data.
 */


    /**
     * Retrieves all categories from the data store.
     *
     * @return A list of all categories.
     */
    List<Category> getAllCategories();

    /**
     * Retrieves a specific category by its ID.
     *
     * @param categoryId The ID of the category to retrieve.
     * @return The Category object if found, or null otherwise.
     */
    Category getCategoryById(int categoryId);

    Category add(Category category);


}
