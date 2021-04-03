package spring.fundamentals.springbootex.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SellerDto {
    @NotNull(message = "First name cannot be null")
    @Length(min = 2, message = "Name must be at least 2 characters")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Length(min = 2, message = "Name must be at least 2 characters")
    private String lastName;
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18 y. old")
    private int age;
    @NotNull
    @DecimalMin(value = "0", message = "Salary must be a positive number")
    private BigDecimal salary;
    @NotNull
    private String shopName;
}
