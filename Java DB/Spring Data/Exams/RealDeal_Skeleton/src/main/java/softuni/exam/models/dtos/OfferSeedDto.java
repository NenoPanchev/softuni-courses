package softuni.exam.models.dtos;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Seller;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {
    @XmlElement
    private String description;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;
    @XmlElement(name = "car")
    private CarIdDto car;
    @XmlElement(name = "seller")
    private SellerIdDto seller;

    public OfferSeedDto() {
    }

    @Length(min = 5)
    public String getDescription() {
        return description;
    }

    public OfferSeedDto setDescription(String description) {
        this.description = description;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public OfferSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public OfferSeedDto setAddedOn(String addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public OfferSeedDto setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    public CarIdDto getCar() {
        return car;
    }

    public OfferSeedDto setCar(CarIdDto car) {
        this.car = car;
        return this;
    }

    public SellerIdDto getSeller() {
        return seller;
    }

    public OfferSeedDto setSeller(SellerIdDto seller) {
        this.seller = seller;
        return this;
    }
}
