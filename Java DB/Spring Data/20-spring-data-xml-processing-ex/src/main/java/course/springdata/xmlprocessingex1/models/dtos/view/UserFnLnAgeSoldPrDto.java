package course.springdata.xmlprocessingex1.models.dtos.view;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserFnLnAgeSoldPrDto {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute
    private int age;
    @XmlElement(name = "sold-products")
    private ProductCountAndListDto soldProducts;

    public UserFnLnAgeSoldPrDto() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductCountAndListDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductCountAndListDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
