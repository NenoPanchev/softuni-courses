package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class SaleExportDto {
    @Expose
    @SerializedName("Make")
    private String carMake;
    @Expose
    @SerializedName("Model")
    private String carModel;
    @Expose
    @SerializedName("Discount")
    private BigDecimal discount;
}
