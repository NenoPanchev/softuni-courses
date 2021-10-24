package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{
    private Float shooting;
    private Float passing;
    private Float endurance;

    public Stat() {
    }

    @Column(nullable = false)
    public Float getShooting() {
        return shooting;
    }

    public Stat setShooting(Float shooting) {
        this.shooting = shooting;
        return this;
    }

    @Column(nullable = false)
    public Float getPassing() {
        return passing;
    }

    public Stat setPassing(Float passing) {
        this.passing = passing;
        return this;
    }

    @Column(nullable = false)
    public Float getEndurance() {
        return endurance;
    }

    public Stat setEndurance(Float endurance) {
        this.endurance = endurance;
        return this;
    }
}
