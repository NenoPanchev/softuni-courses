package course.springdata.xmlprocessingex1.models.dtos.view;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductCountAndListDto {
    @XmlAttribute
    private int count;
    @XmlElement(name = "product")
    private List<ProductNameAndPriceDto> products;

    public ProductCountAndListDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNameAndPriceDto> products) {
        this.products = products;
    }
}
