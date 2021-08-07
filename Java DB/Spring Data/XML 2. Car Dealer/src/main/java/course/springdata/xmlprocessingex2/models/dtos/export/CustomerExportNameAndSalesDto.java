package course.springdata.xmlprocessingex2.models.dtos.export;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportNameAndSalesDto {
    @XmlAttribute(name = "full-name")
    private String name;
    @XmlAttribute(name = "bought-cars")
    private int boughtCars;
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;
}
