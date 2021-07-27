package softuni.exam.models.dtos;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entity.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedDto {
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement
    private Rating rating;
    @XmlElement
    private String town;

    public SellerSeedDto() {
    }

    @Length(min = 2, max = 19)
    public String getFirstName() {
        return firstName;
    }

    public SellerSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Length(min = 2, max = 19)
    public String getLastName() {
        return lastName;
    }

    public SellerSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public SellerSeedDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotNull
    public Rating getRating() {
        return rating;
    }

    public SellerSeedDto setRating(Rating rating) {
        this.rating = rating;
        return this;
    }

    @NotNull
    @NotBlank
    public String getTown() {
        return town;
    }

    public SellerSeedDto setTown(String town) {
        this.town = town;
        return this;
    }
}
