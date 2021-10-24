package softuni.exam.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{
    private String serialNumber;
    private BigDecimal price;
    private LocalDateTime takeOff;
    private Town fromTown;
    private Town toTown;
    private Plane plane;
    private Passenger passenger;

    public Ticket() {
    }

    @Column(name = "serial_number", unique = true)
    public String getSerialNumber() {
        return serialNumber;
    }

    public Ticket setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public Ticket setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "take_off")
    public LocalDateTime getTakeOff() {
        return takeOff;
    }

    public Ticket setTakeOff(LocalDateTime takeoff) {
        this.takeOff = takeoff;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "from_town_id")
    public Town getFromTown() {
        return fromTown;
    }

    public Ticket setFromTown(Town fromTown) {
        this.fromTown = fromTown;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "to_town_id")
    public Town getToTown() {
        return toTown;
    }

    public Ticket setToTown(Town toTown) {
        this.toTown = toTown;
        return this;
    }

    @ManyToOne
    public Plane getPlane() {
        return plane;
    }

    public Ticket setPlane(Plane plane) {
        this.plane = plane;
        return this;
    }

    @ManyToOne
    public Passenger getPassenger() {
        return passenger;
    }

    public Ticket setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }
}
