package springdataautomappinglab.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeeViewDto {
    private String firstName;
    private String lastName;
    private String addressCity;

}
