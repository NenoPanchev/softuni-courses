package com.example.december2021exam.model.service;

import com.example.december2021exam.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel extends BaseServiceModel{
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryNameEnum category;

    public ProductServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductServiceModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
