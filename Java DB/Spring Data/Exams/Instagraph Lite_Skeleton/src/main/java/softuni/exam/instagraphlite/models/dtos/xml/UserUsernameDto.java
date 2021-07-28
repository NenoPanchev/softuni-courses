package softuni.exam.instagraphlite.models.dtos.xml;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserUsernameDto {
    @XmlElement
    private String username;

    public UserUsernameDto() {
    }

    @NotBlank
    public String getUsername() {
        return username;
    }

    public UserUsernameDto setUsername(String username) {
        this.username = username;
        return this;
    }
}
