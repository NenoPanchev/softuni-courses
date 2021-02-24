package springdataautomappinglab.services;

import springdataautomappinglab.dto.EmployeeViewDto;
import springdataautomappinglab.entities.Employee;

public interface EmployeeService {
    void save(Employee employee);

    EmployeeViewDto getEmployeeView(Employee employee);
}
