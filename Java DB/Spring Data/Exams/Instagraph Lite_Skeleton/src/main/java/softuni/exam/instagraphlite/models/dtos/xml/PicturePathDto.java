package softuni.exam.instagraphlite.models.dtos.xml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class PicturePathDto {
    @XmlElement
    private String path;

    public PicturePathDto() {
    }

    @NotBlank
    public String getPath() {
        return path;
    }

    public PicturePathDto setPath(String path) {
        this.path = path;
        return this;
    }
}
