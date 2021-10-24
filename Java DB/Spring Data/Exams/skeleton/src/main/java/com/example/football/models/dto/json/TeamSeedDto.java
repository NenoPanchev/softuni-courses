package com.example.football.models.dto.json;


import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TeamSeedDto {
    @Expose
    private String name;
    @Expose
    private String stadiumName;
    @Expose
    private Integer fanBase;
    @Expose
    private String history;
    @Expose
    private String townName;

    public TeamSeedDto() {
    }

    @Length(min = 3)
    public String getName() {
        return name;
    }

    public TeamSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 3)
    public String getStadiumName() {
        return stadiumName;
    }

    public TeamSeedDto setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
        return this;
    }

    @Min(1000)
    @NotNull
    public Integer getFanBase() {
        return fanBase;
    }

    public TeamSeedDto setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
        return this;
    }

    @Length(min = 10)
    public String getHistory() {
        return history;
    }

    public TeamSeedDto setHistory(String history) {
        this.history = history;
        return this;
    }

    @Length(min = 2)
    public String getTownName() {
        return townName;
    }

    public TeamSeedDto setTownName(String townName) {
        this.townName = townName;
        return this;
    }
}
