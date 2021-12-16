package com.example.december2021exam.model.service;

import com.example.december2021exam.model.entity.enums.CategoryNameEnum;

public class CategoryServiceModel extends BaseServiceModel{
    private CategoryNameEnum name;
    private String description;

    public CategoryServiceModel() {
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryServiceModel setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
