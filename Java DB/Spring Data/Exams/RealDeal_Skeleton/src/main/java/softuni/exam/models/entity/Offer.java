package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    private BigDecimal price;
    private String description;
    private boolean hasGoldStatus;
    private LocalDateTime addedOn;
    private Car car;
    private Seller seller;
    private Set<Picture> pictures;

    public Offer() {
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "has_gold_status")
    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public Offer setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
        return this;
    }

    @Column(name = "added_on")
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Offer setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(description, offer.description) && Objects.equals(addedOn, offer.addedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, addedOn);
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public Offer setCar(Car car) {
        this.car = car;
        return this;
    }

    @ManyToOne
    public Seller getSeller() {
        return seller;
    }

    public Offer setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "picture_id", referencedColumnName = "id"))
    public Set<Picture> getPictures() {
        return pictures;
    }

    public Offer setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
