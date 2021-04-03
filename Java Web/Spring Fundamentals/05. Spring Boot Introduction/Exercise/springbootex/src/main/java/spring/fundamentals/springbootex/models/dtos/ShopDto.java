package spring.fundamentals.springbootex.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ShopDto {
    @Length(min = 2, message = "Name must be at least 2 characters long")
    private String name;
    @NotNull(message = "Address cannot be null")
    @Length(min = 2, message = "Address must be at least 2 characters long")
    private String address;
    @NotNull(message = "Town cannot be null")
    private String town;
}
