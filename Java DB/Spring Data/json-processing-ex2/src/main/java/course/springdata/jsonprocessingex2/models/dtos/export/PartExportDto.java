package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PartExportDto {
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("Price")
    private BigDecimal price;
}
