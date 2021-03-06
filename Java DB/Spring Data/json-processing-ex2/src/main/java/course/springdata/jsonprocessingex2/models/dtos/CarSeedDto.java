package course.springdata.jsonprocessingex2.models.dtos;

import com.google.gson.annotations.Expose;
import course.springdata.jsonprocessingex2.models.entities.Part;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class CarSeedDto {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private Long travelledDistance;
    private Set<Part> parts;
}
