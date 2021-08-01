package com.example.football.models.dto.json;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TownSeedDto {
    @Expose
    private String name;
    @Expose
    private Integer population;
    @Expose
    private String travelGuide;

    public TownSeedDto() {
    }

    @Length(min = 2)
    public String getName() {
        return name;
    }

    public TownSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    @Min(1)
    @NotNull
    public Integer getPopulation() {
        return population;
    }

    public TownSeedDto setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    @Length(min = 10)
    public String getTravelGuide() {
        return travelGuide;
    }

    public TownSeedDto setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
        return this;
    }
}
