package com.example.battleships.model.service;

import com.example.battleships.model.entity.CategoryNameEnum;

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
