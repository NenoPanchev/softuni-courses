package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{
    public Bike() {
    }

    public Bike(String model, BigDecimal price, String fuelType) {
        super(model, price, fuelType);
    }

    public Bike(long id, String model, BigDecimal price, String fuelType) {
        super(id, model, price, fuelType);
    }
}
