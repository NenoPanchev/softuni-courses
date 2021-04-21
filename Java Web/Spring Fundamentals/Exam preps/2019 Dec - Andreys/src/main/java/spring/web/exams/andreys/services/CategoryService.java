package spring.web.exams.andreys.services;

import spring.web.exams.andreys.model.entity.CategoryName;
import spring.web.exams.andreys.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();
    CategoryServiceModel findByCategoryName(CategoryName categoryName);
}
