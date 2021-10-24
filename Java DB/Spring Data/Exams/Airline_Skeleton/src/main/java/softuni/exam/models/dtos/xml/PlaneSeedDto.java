package softuni.exam.models.dtos.xml;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneSeedDto {
    @XmlElement(name = "register-number")
    private String registerNumber;
    @XmlElement
    private Integer capacity;
    @XmlElement
    private String airline;

    public PlaneSeedDto() {
    }

    @Length(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public PlaneSeedDto setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
        return this;
    }

    @Positive
    public Integer getCapacity() {
        return capacity;
    }

    public PlaneSeedDto setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    @Length(min = 2)
    public String getAirline() {
        return airline;
    }

    public PlaneSeedDto setAirline(String airline) {
        this.airline = airline;
        return this;
    }
}
