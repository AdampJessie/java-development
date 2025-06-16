package com.pluralsight.NorthwindTradersSB2.dao.interfaces;
import com.pluralsight.NorthwindTradersSB2.models.Product;

import java.util.List;

/**
 * Interface for Data Access Object (DAO) operations related to the Product model.
 * This interface defines the standard operations to be performed on the Product data.
 */

public interface IProductDAO {

    /**
     * Adds a new product to the data store.
     *
     * @param product The Product object to be added.
     * @return the new product
     */
    Product add(Product product);

    /**
     * Retrieves all products from the data store.
     *
     * @return A list of all products.
     */
    List<Product> getAllProducts();

    /**
     * Retrieves a specific product by its ID.
     *
     * @param productID The ID of the product to retrieve.
     * @return The Product object if found, or null otherwise.
     */
    Product getProductByID(int productID);

    /**
     * Updates an existing product in the data store.
     *
     * @param productID The ID of the product to update.
     * @param product The Product object with updated information.
     */
    void update(int productID, Product product);

    /**
     * Deletes a product from the data store.
     *
     * @param productID The ID of the product to delete.
     */
    void delete(int productID);

}
