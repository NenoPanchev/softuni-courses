package course.springdata.jsonprocessingex2.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerSeedDto {
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;
}
