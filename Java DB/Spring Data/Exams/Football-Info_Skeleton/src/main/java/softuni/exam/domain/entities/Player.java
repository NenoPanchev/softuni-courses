package softuni.exam.domain.entities;

import softuni.exam.domain.entities.enums.Position;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{
    private String firstName;
    private String lastName;
    private Integer number;
    private BigDecimal salary;
    private Position position;
    private Picture picture;
    private Team team;

    public Player() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public Player setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", length = 15, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public Player setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(nullable = false)
    public Integer getNumber() {
        return number;
    }

    public Player setNumber(Integer number) {
        this.number = number;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getSalary() {
        return salary;
    }

    public Player setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Position getPosition() {
        return position;
    }

    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Picture getPicture() {
        return picture;
    }

    public Player setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Team getTeam() {
        return team;
    }

    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }
}
