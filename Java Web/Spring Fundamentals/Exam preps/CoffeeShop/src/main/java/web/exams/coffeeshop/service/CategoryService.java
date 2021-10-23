package web.exams.coffeeshop.service;

import web.exams.coffeeshop.model.entity.Category;
import web.exams.coffeeshop.model.entity.CategoryNameEnum;

public interface CategoryService {
    void seedCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
