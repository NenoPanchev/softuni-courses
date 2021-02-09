package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck() {
    }

    public Truck(String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public Truck(long id, String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(id, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Column(name = "trucks")
    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
