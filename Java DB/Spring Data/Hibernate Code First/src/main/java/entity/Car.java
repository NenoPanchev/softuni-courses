package entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private int seats;
    private PlateNumber plate;

    public Car() {
    }

    public Car(String model, BigDecimal price, String fuelType, int seats) {
        super(model, price, fuelType);
        this.seats = seats;
    }

    public Car(long id, String model, BigDecimal price, String fuelType, int seats) {
        super(id, model, price, fuelType);
        this.seats = seats;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @OneToOne(mappedBy = "car")
    public PlateNumber getPlate() {
        return plate;
    }

    public void setPlate(PlateNumber plate) {
        this.plate = plate;
    }
}
