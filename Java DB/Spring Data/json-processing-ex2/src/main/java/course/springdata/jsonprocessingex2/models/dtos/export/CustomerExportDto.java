package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerExportDto {
    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("BirthDate")
    private String birthDate;
    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;
    @Expose
    @SerializedName("Sales")
    private List<SaleExportDto> sales;
}
