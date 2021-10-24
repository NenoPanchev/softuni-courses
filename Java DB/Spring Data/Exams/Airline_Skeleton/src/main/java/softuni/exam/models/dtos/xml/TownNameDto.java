package softuni.exam.models.dtos.xml;

import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownNameDto {
    @XmlElement
    private String name;

    public TownNameDto() {
    }

    @Length(min = 2)
    public String getName() {
        return name;
    }

    public TownNameDto setName(String name) {
        this.name = name;
        return this;
    }
}
