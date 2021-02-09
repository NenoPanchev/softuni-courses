package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{
    private int passangerCapacity;
    private Company company;

    public Plane() {
    }

    public Plane(String model, BigDecimal price, String fuelType, int passangerCapacity, Company company) {
        super(model, price, fuelType);
        this.passangerCapacity = passangerCapacity;
        this.company = company;
    }

    public Plane(long id, String model, BigDecimal price, String fuelType, int passangerCapacity, Company company) {
        super(id, model, price, fuelType);
        this.passangerCapacity = passangerCapacity;
        this.company = company;
    }

    @Column(name = "passanger_capacity")
    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    public void setPassangerCapacity(int passangerCapacity) {
        this.passangerCapacity = passangerCapacity;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }
}
