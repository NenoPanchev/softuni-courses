package softuni.exam.models.dtos.xml;

import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneRegisterNumberDto {
    @XmlElement(name = "register-number")
    private String registerNumber;

    public PlaneRegisterNumberDto() {
    }

    @Length(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public PlaneRegisterNumberDto setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
        return this;
    }
}
