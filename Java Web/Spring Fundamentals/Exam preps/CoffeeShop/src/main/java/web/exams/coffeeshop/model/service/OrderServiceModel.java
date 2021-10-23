package web.exams.coffeeshop.model.service;

import web.exams.coffeeshop.model.entity.CategoryNameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryNameEnum category;
    private String description;

    public OrderServiceModel() {
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

}
