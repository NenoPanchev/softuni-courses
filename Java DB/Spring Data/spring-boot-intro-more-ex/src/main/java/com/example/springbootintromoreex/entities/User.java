package com.example.springbootintromoreex.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private int id;
    @Size(min = 4, max = 30)
    private String username;
    private String password;
    private String email;
    private LocalDateTime registeredOn;
    private LocalDateTime lastTimeLoggedIn;
    private int age;
    private boolean isDeleted;
    private Town bornTown;
    private Town currentlyLivingInTown;
    private String firstName;
    private String lastName;
    private String fullName;
    private Set<User> friends;
    private Set<Album> album;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username", length = 30, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "registered_on")
    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Column(name = "last_time_logged_in")
    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    @Column()
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "is_deleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    public Town getCurrentlyLivingInTown() {
        return currentlyLivingInTown;
    }

    public void setCurrentlyLivingInTown(Town currentlyLivingInTown) {
        this.currentlyLivingInTown = currentlyLivingInTown;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    @OneToMany(mappedBy = "user")
    public Set<Album> getAlbum() {
        return album;
    }

    public void setAlbum(Set<Album> album) {
        this.album = album;
    }
}
