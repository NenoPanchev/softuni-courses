package com.example.battleship.model.service;

public abstract class BaseServiceModel {
    private Long id;

    public BaseServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public BaseServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}
