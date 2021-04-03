package spring.fundamentals.springbootex.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CategoryDto {
    @Length(min = 2)
    @NotNull
    private String name;
}
