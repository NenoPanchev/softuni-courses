package com.example.december2021exam.model.binding;

import com.example.december2021exam.model.entity.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {
    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoryNameEnum category;

    public ProductAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 5, message = "Description length must be 5 or more characters!")
    public String getDescription() {
        return description;
    }



    @FutureOrPresent(message = "Date and time cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull(message = "Enter a valid date!")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }


    @Positive(message = "Price must be positive number")
    @NotNull(message = "Enter a valid price!")
    public BigDecimal getPrice() {
        return price;
    }


    @NotNull(message = "Choose a valid category")
    public CategoryNameEnum getCategory() {
        return category;
    }
    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

}
