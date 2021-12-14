package com.example.battleship.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity {
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private Category category;
    private User user;

    public Ship() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public Long getHealth() {
        return health;
    }

    public Ship setHealth(Long health) {
        this.health = health;
        return this;
    }

    @Column(nullable = false)
    public Long getPower() {
        return power;
    }

    public Ship setPower(Long power) {
        this.power = power;
        return this;
    }

    @Column(nullable = false)
    public LocalDate getCreated() {
        return created;
    }

    public Ship setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Ship setUser(User user) {
        this.user = user;
        return this;
    }
}
