package springdataautomappinglab.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springdataautomappinglab.dto.EmployeeViewDto;
import springdataautomappinglab.entities.Employee;
import springdataautomappinglab.repositories.EmployeeRepository;
import springdataautomappinglab.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.saveAndFlush(employee);
    }

    @Override
    public EmployeeViewDto getEmployeeView(Employee employee) {
        return this.modelMapper.map(employee, EmployeeViewDto.class);
    }
}
