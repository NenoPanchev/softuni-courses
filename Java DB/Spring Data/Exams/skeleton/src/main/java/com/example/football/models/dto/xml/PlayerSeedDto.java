package com.example.football.models.dto.xml;

import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.models.entity.enums.Position;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {
    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement
    private String email;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement
    private Position position;
    @XmlElement
    private TownNameDto town;
    @XmlElement
    private TeamNameDto team;
    @XmlElement
    private StatIdDto stat;

    public PlayerSeedDto() {
    }

    @Length(min = 3)
    public String getFirstName() {
        return firstName;
    }

    public PlayerSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Length(min = 3)
    public String getLastName() {
        return lastName;
    }

    public PlayerSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public PlayerSeedDto setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank
    public String getBirthDate() {
        return birthDate;
    }

    public PlayerSeedDto setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
    public TownNameDto getTown() {
        return town;
    }

    public PlayerSeedDto setTown(TownNameDto town) {
        this.town = town;
        return this;
    }

    @NotNull
    public TeamNameDto getTeam() {
        return team;
    }

    public PlayerSeedDto setTeam(TeamNameDto team) {
        this.team = team;
        return this;
    }

    @NotNull
    public StatIdDto getStat() {
        return stat;
    }

    public PlayerSeedDto setStat(StatIdDto stat) {
        this.stat = stat;
        return this;
    }
}
