package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CustomerExportNameAndSalesDto {
    @Expose
    @SerializedName("fullName")
    private String name;
    @Expose
    private int boughtCars;
    @Expose
    private BigDecimal spentMoney;
}
