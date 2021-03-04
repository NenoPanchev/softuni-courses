package coursespringdata.jsonprocessingex1.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserFnLnAgeSoldPrDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
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
