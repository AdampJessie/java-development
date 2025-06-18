package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


    public class ProductController {

        private List<Product> products;

        public ProductController() {
            products = new ArrayList<>();
            // Add some initial products
            products.add(new Product(1, "FL Studio", 1, 100));
            products.add(new Product(2, "Crab", 2, 20));
            products.add(new Product(3, "Milk", 3, 5));
        }

        @RequestMapping(path = "/products", method = RequestMethod.GET)
        public List<Product> getAllCategories() {
            return products;
        }

        @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
        public Product getProductById(@PathVariable int productId) {
            for (Product product : products) {
                if (product.getProductId() == productId) {
                    return product;
                }
            }
            return null; // Return null if product with given ID is not found
        }

    }


