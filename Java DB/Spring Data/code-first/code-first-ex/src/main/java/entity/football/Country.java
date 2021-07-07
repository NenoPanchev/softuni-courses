package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    private String initials;
    private String name;
    private Set<Continent> continents;
    private Set<Town> towns;

    public Country() {
    }

    @Column(unique = true, nullable = false, columnDefinition = "CHAR(3)")
    public String getInitials() {
        return initials;
    }

    public Country setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id")
    )
    public Set<Continent> getContinents() {
        return continents;
    }

    public Country setContinents(Set<Continent> continents) {
        this.continents = continents;
        return this;
    }

    @OneToMany(mappedBy = "country")
    public Set<Town> getTowns() {
        return towns;
    }

    public Country setTowns(Set<Town> towns) {
        this.towns = towns;
        return this;
    }
}
