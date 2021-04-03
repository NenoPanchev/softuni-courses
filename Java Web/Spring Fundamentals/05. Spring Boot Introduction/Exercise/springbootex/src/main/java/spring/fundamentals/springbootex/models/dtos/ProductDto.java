package spring.fundamentals.springbootex.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductDto {
    @NotNull
    @Length(min = 2)
    private String name;
    @NotNull
    @DecimalMin("0")
    private BigDecimal price;
    private LocalDate bestBefore;
    private String categoryName;
}
