package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import java.time.LocalDate;

public class CarSeedDto {
    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private String kilometers;

    @Expose
    private String registeredOn;

    public CarSeedDto() {
    }

    @Length(min = 2, max = 19)
    public String getMake() {
        return make;
    }

    public CarSeedDto setMake(String make) {
        this.make = make;
        return this;
    }

    @Length(min = 2, max = 19)
    public String getModel() {
        return model;
    }

    public CarSeedDto setModel(String model) {
        this.model = model;
        return this;
    }

    @Min(0)
    public String getKilometers() {
        return kilometers;
    }

    public CarSeedDto setKilometers(String kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public CarSeedDto setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }
}
