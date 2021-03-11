package course.springdata.xmlprocessingex1.models.dtos.view;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsDto {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlElement(name = "sold-products")
    private ProductViewSoldRootDto soldProducts;

    public UserSoldProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProductViewSoldRootDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProductsDtos(ProductViewSoldRootDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
