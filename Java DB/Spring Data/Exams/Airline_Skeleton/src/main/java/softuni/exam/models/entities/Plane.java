package softuni.exam.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{
    private String registerNumber;
    private Integer capacity;
    private String airline;

    public Plane() {
    }

    @Column(name = "register_number", unique = true, nullable = false)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public Plane setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
        return this;
    }

    @Column(nullable = false)
    public Integer getCapacity() {
        return capacity;
    }

    public Plane setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    @Column(nullable = false)
    public String getAirline() {
        return airline;
    }

    public Plane setAirline(String airline) {
        this.airline = airline;
        return this;
    }
}
