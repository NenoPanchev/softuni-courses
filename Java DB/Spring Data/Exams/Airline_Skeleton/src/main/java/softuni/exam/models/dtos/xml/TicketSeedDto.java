package softuni.exam.models.dtos.xml;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedDto {
    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeOff;
    @XmlElement(name = "from-town")
    private TownNameDto fromTown;
    @XmlElement(name = "to-town")
    private TownNameDto toTown;
    @XmlElement
    private PassengerEmailDto passenger;
    @XmlElement
    private PlaneRegisterNumberDto plane;

    public TicketSeedDto() {
    }

    @Length(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public TicketSeedDto setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public TicketSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public TicketSeedDto setTakeOff(String takeOff) {
        this.takeOff = takeOff;
        return this;
    }

    public TownNameDto getFromTown() {
        return fromTown;
    }

    public TicketSeedDto setFromTown(TownNameDto fromTown) {
        this.fromTown = fromTown;
        return this;
    }

    public TownNameDto getToTown() {
        return toTown;
    }

    public TicketSeedDto setToTown(TownNameDto toTown) {
        this.toTown = toTown;
        return this;
    }

    public PassengerEmailDto getPassenger() {
        return passenger;
    }

    public TicketSeedDto setPassenger(PassengerEmailDto passenger) {
        this.passenger = passenger;
        return this;
    }

    public PlaneRegisterNumberDto getPlane() {
        return plane;
    }

    public TicketSeedDto setPlane(PlaneRegisterNumberDto plane) {
        this.plane = plane;
        return this;
    }
}
