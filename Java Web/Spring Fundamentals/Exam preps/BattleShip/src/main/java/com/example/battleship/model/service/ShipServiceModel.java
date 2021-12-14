package com.example.battleship.model.service;

import com.example.battleship.model.entity.enums.CategoryNameEnum;

import java.time.LocalDate;

public class ShipServiceModel extends BaseServiceModel{
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
