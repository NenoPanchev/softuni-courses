package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String make;
    private String model;
    private Integer kilometers;
    private LocalDate registeredOn;
    private Set<Picture> pictures;

    public Car() {
    }

    @Column(length = 19)
    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    @Column(length = 19)
    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public Car setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    @Column(name = "registered_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public Car setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(kilometers, car.kilometers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, kilometers);
    }

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public Car setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
