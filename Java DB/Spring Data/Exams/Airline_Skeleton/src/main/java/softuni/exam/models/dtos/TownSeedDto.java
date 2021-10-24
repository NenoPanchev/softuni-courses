package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TownSeedDto {
    @Expose
    private String name;
    @Expose
    private Long population;
    @Expose
    private String guide;

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

    @Positive
    @NotNull
    public Long getPopulation() {
        return population;
    }

    public TownSeedDto setPopulation(Long population) {
        this.population = population;
        return this;
    }

    public String getGuide() {
        return guide;
    }

    public TownSeedDto setGuide(String guide) {
        this.guide = guide;
        return this;
    }
}
