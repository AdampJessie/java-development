package com.pluralsight.NorthwindTradersAPI.Controller;

import com.pluralsight.NorthwindTradersAPI.Model.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {

    private List<Category> categories;

    public CategoryController() {
        categories = new ArrayList<>();
        // Add some initial categories
        categories.add(new Category(1, "Digital"));
        categories.add(new Category(2, "Seafood"));
        categories.add(new Category(3, "Dairy"));
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categories;
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null; // Return null if category with given ID is not found
    }

}
