package softuni.exam.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity{
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private String email;
    private Town town;
    private Set<Ticket> tickets;

    public Passenger() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public Passenger setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public Passenger setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public Passenger setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Passenger setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public Passenger setEmail(String email) {
        this.email = email;
        return this;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public Passenger setTown(Town town) {
        this.town = town;
        return this;
    }

    @OneToMany(mappedBy = "passenger", fetch = FetchType.EAGER)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public Passenger setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
        return this;
    }
}
