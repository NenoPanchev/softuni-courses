package course.springdata.xmlprocessingex2.models.dtos.export;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportWithoutIdDto {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlElement(name = "parts")
    private PartViewRootDto parts;
}
