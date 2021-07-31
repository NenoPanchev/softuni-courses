package softuni.exam.domain.dtos.json;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;
import softuni.exam.domain.dtos.xml.PictureSeedDto;
import softuni.exam.domain.dtos.xml.TeamSeedDto;
import softuni.exam.domain.entities.enums.Position;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PlayerSeedDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer number;
    @Expose
    private BigDecimal salary;
    @Expose
    private Position position;
    @Expose
    private PictureSeedDto picture;
    @Expose
    private TeamSeedDto team;

    public PlayerSeedDto() {
    }

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public PlayerSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Length(min = 3, max = 15)
    public String getLastName() {
        return lastName;
    }

    public PlayerSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Min(1)
    @Max(99)
    public Integer getNumber() {
        return number;
    }

    public PlayerSeedDto setNumber(Integer number) {
        this.number = number;
        return this;
    }

    @Positive
    @NotNull
    public BigDecimal getSalary() {
        return salary;
    }

    public PlayerSeedDto setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    @NotNull
    public Position getPosition() {
        return position;
    }

    public PlayerSeedDto setPosition(Position position) {
        this.position = position;
        return this;
    }

    @NotNull
    public PictureSeedDto getPicture() {
        return picture;
    }

    public PlayerSeedDto setPicture(PictureSeedDto picture) {
        this.picture = picture;
        return this;
    }

    @NotNull
    public TeamSeedDto getTeam() {
        return team;
    }

    public PlayerSeedDto setTeam(TeamSeedDto team) {
        this.team = team;
        return this;
    }
}
