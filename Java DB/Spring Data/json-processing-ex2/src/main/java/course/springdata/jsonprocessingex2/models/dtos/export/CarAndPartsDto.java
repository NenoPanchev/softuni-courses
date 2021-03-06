package course.springdata.jsonprocessingex2.models.dtos.export;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CarAndPartsDto {
    @Expose
    private CarExportWithoutIdDto car;
    @Expose
    private List<PartExportDto> parts;
}
