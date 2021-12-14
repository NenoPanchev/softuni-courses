package com.example.battleship.service;

import com.example.battleship.model.entity.enums.CategoryNameEnum;
import com.example.battleship.model.service.CategoryServiceModel;

public interface CategoryService {

    void seedServices();
    CategoryServiceModel findByCategoryNameEnum(CategoryNameEnum name);
}
