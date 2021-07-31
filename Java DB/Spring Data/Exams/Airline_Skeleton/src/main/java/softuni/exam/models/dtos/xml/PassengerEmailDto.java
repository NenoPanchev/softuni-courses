package softuni.exam.models.dtos.xml;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "passenger")
@XmlAccessorType(XmlAccessType.FIELD)
public class PassengerEmailDto {
    @XmlElement
    private String email;

    public PassengerEmailDto() {
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public PassengerEmailDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
