package course.springdata.jsonprocessingex2.models.dtos;

import com.google.gson.annotations.Expose;
import course.springdata.jsonprocessingex2.models.entities.Supplier;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PartSeedDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;
    private Supplier supplier;
}
