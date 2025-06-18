package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.ICategoryDAO;
import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private final ICategoryDAO categoryDAO;

    @Autowired
    public CategoryController(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    private List<Category> categories;

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

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return categoryDAO.add(category);
    }

}
