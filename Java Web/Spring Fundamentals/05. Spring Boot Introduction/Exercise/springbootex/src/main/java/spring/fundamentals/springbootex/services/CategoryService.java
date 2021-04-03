package spring.fundamentals.springbootex.services;

import spring.fundamentals.springbootex.models.entities.Category;

public interface CategoryService {
    void seedCategory(String categoryName);
    Category getByName(String name);
}
