package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.Rating;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private Rating rating;
    private String town;

    public Seller() {
    }

    @Column(name = "first_name", length = 19)
    public String getFirstName() {
        return firstName;
    }

    public Seller setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", length = 19)
    public String getLastName() {
        return lastName;
    }

    public Seller setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public Seller setEmail(String email) {
        this.email = email;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Rating getRating() {
        return rating;
    }

    public Seller setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    @Column(nullable = false)
    public String getTown() {
        return town;
    }

    public Seller setTown(String town) {
        this.town = town;
        return this;
    }
}
