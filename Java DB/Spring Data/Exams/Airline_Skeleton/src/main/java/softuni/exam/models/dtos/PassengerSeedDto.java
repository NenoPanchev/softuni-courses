package softuni.exam.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class PassengerSeedDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private String phoneNumber;
    @Expose
    private String email;
    @Expose
    private String town;

    public PassengerSeedDto() {
    }

    @Length(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public PassengerSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Length(min = 2)
    public String getLastName() {
        return lastName;
    }

    public PassengerSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Positive
    public Integer getAge() {
        return age;
    }

    public PassengerSeedDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    @NotBlank
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PassengerSeedDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public PassengerSeedDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public PassengerSeedDto setTown(String town) {
        this.town = town;
        return this;
    }
}
