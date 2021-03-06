package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarExportDto {
    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Make")
    private String make;
    @Expose
    @SerializedName("Model")
    private String model;
    @Expose
    @SerializedName("TravelledDistance")
    private Long travelledDistance;
}
