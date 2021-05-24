package spring.softunimusicdb.model.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class ArtistSeedDto {
    @Expose
    private String name;
    @Expose
    private String careerInformation;

    public ArtistSeedDto() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public ArtistSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public String getCareerInformation() {
        return careerInformation;
    }

    public ArtistSeedDto setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
