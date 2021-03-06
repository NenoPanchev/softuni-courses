package course.springdata.jsonprocessingex2.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierSeedDto {
    @Expose
    private String name;
    @Expose
    private boolean isImporter;
}
