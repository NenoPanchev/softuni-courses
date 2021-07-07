package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    private String name;
    private Country country;
    private Set<Team> teams;

    public Town() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public Town setCountry(Country country) {
        this.country = country;
        return this;
    }

    @OneToMany(mappedBy = "town")
    public Set<Team> getTeams() {
        return teams;
    }

    public Town setTeams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }
}
