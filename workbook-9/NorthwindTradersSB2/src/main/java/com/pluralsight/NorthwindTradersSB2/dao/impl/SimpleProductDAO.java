package com.pluralsight.NorthwindTradersSB2.dao.impl;

import com.pluralsight.NorthwindTradersSB2.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersSB2.models.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleProductDAO implements IProductDAO {

    private List<Product> products;

    public SimpleProductDAO() {
        this.products = new ArrayList<>();
        // Add some initial products
        products.add(new Product(1, 150.75, "Amazon"));
        products.add(new Product(2, 89.99, "Walmart"));
        products.add(new Product(3, 200.00, "Best Buy"));
    }

    @Override
    public Product add(Product product) {
        int maxID = 0;
        for (Product t : products) {
            if (t.getProductID() > maxID) {
                maxID = t.getProductID();
            }
        }
        product.setProductID(maxID + 1); // Increment max ID by 1
        products.add(product);
        return product;
    }


    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductByID(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int productID, Product product) {
        int index = getProductIndex(productID);
        if (index != -1) {
            products.set(index, product);
        }
    }

    @Override
    public void delete(int productID) {
        int index = getProductIndex(productID);
        if (index != -1) {
            products.remove(index);
        }
    }

    private int getProductIndex(int productID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                return i;
            }
        }
        return -1;
    }

}
