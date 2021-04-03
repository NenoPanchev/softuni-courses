package spring.fundamentals.springbootlab.entities;

import spring.fundamentals.springbootlab.entities.enums.EngineEnum;
import spring.fundamentals.springbootlab.entities.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    private String description;
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    private String imageUrl;
    private double mileage;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    private int year;
    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }
}
