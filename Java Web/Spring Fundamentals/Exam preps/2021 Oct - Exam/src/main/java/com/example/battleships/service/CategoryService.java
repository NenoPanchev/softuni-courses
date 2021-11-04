package com.example.battleships.service;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.CategoryNameEnum;
import com.example.battleships.model.service.CategoryServiceModel;

public interface CategoryService {
    void seedCategories();

    CategoryServiceModel findByCategoryNameEnum(CategoryNameEnum category);
}
