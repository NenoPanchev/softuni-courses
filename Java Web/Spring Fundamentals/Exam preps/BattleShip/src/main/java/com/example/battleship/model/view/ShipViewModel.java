package com.example.battleship.model.view;

public class ShipViewModel {
    private String name;
    private Long power;
    private Long health;

    public ShipViewModel() {
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }
}
