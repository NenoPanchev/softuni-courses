package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String name;
    private LocalDateTime dateAndTime;
    private Car car;
    private Set<Offer> offers;

    public Picture() {
    }

    @Column(length = 19, unique = true)
    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "date_and_time")
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Picture setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public Picture setCar(Car car) {
        this.car = car;
        return this;
    }

    @ManyToMany(mappedBy = "pictures")
    public Set<Offer> getOffers() {
        return offers;
    }

    public Picture setOffers(Set<Offer> offers) {
        this.offers = offers;
        return this;
    }
}
