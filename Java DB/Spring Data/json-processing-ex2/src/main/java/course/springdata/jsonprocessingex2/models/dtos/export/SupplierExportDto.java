package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierExportDto {
    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    private int partsCount;
}
