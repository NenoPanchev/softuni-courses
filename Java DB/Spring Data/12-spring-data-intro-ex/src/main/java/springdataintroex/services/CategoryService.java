package springdataintroex.services;

import springdataintroex.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;
    Category getCategoryById(Long id);
    int getAllCategoryCount();
}
