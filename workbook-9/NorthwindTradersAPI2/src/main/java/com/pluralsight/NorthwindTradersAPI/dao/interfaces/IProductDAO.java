package com.pluralsight.NorthwindTradersAPI.dao.interfaces;

import com.pluralsight.NorthwindTradersAPI.model.Product;

import java.util.List;

public interface IProductDAO {

/**
 * Interface for Data Access Object (DAO) operations related to the Product model.
 * This interface defines the standard operations to be performed on the Product data.
 */


    /**
     * Retrieves all products from the data store.
     *
     * @return A list of all products.
     */
    List<Product> getAllProducts();

    /**
     * Retrieves a specific transaction by its ID.
     *
     * @param transactionId The ID of the transaction to retrieve.
     * @return The Product object if found, or null otherwise.
     */
    Product getProductById(int transactionId);
}



