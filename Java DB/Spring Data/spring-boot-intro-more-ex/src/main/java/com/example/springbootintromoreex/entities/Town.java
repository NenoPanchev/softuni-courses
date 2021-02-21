package com.example.springbootintromoreex.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    private int id;
    private String name;
    private String country;
    private Set<User> usersBornInTown;
    private Set<User> usersLivingInTown;

    public Town() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getUsersBornInTown() {
        return usersBornInTown;
    }

    public void setUsersBornInTown(Set<User> usersBornInTown) {
        this.usersBornInTown = usersBornInTown;
    }

    @OneToMany(mappedBy = "currentlyLivingInTown")
    public Set<User> getUsersLivingInTown() {
        return usersLivingInTown;
    }

    public void setUsersLivingInTown(Set<User> usersLivingInTown) {
        this.usersLivingInTown = usersLivingInTown;
    }
}
