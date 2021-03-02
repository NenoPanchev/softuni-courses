package springdataautomappingex.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameAddDto {
    @Pattern(regexp = "^[A-Z].{2,99}", message = "Invalid title.")
    private String title;
    @DecimalMin(value = "0", message = "Price cannot be negative.")
    private BigDecimal price;
    @Min(value = 0, message = "Size cannot be negative.")
    private double size;
    @Length(min = 11, max = 11, message = "Incorrect trailer length.")
    private String trailer;
    @Pattern(regexp = "^((http:\\/\\/)|(https:\\/\\/)).+", message = "Invalid URL.")
    private String imageThumbnailURL;
    @Size(min = 20, message = "Description must be at least 20 symbols.")
    private String description;
    private LocalDate releaseDate;
}
