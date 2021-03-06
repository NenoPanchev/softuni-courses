package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class SaleExportFullInfoDto {
    @Expose
    private CarExportWithoutIdDto car;
    @Expose
    private String customerName;
    @Expose
    @SerializedName("Discount")
    private BigDecimal discount;
    @Expose
    private BigDecimal price;
    @Expose
    private BigDecimal priceWithDiscount;
}
