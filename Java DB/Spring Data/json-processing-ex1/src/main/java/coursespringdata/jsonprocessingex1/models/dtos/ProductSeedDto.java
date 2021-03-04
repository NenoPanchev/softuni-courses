package coursespringdata.jsonprocessingex1.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    @NotNull(message = "Product name is required.")
    @Length(min = 3, message = "Product name must be longer than 3 characters")
    private String name;
    @Expose
    @NotNull(message = "Product price is required.")
    @DecimalMin(value = "0", message = "Price cannot be negative.")
    private BigDecimal price;

    public ProductSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
