package com.example.battleships.model.view;

public class ShipViewModel extends BaseViewModel{
    private String name;
    private Long health;
    private Long power;

    public ShipViewModel() {
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipViewModel setPower(Long power) {
        this.power = power;
        return this;
    }

}
