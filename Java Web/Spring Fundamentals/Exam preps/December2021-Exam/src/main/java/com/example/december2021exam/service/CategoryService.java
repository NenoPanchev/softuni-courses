package com.example.december2021exam.service;

import com.example.december2021exam.model.entity.enums.CategoryNameEnum;
import com.example.december2021exam.model.service.CategoryServiceModel;

public interface CategoryService {

    void seedCategories();
    CategoryServiceModel findByName(CategoryNameEnum name);
}
