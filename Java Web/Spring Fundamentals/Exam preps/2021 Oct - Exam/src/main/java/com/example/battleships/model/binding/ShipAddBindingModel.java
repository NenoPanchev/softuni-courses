package com.example.battleships.model.binding;

import com.example.battleships.model.entity.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    @Positive
    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }


    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotNull
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
