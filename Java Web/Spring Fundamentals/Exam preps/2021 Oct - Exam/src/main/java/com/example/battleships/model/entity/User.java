package com.example.battleships.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String fullName;
    private String email;
    private String password;
    private Set<Ship> ships;

    public User() {
    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Set<Ship> getShips() {
        return ships;
    }

    public User setShips(Set<Ship> ships) {
        this.ships = ships;
        return this;
    }
}
