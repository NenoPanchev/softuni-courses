package springdataautomappinglab.init;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdataautomappinglab.entities.Address;
import springdataautomappinglab.entities.Employee;
import springdataautomappinglab.services.AddressService;
import springdataautomappinglab.services.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppInitializer implements CommandLineRunner {
    private final AddressService addressService;
    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public AppInitializer(AddressService addressService, EmployeeService employeeService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("Bulgaria", "Plovdiv", "Ruski");
        this.addressService.save(address);
        Employee employee = new Employee("Pesho", "Peshev",  2222.80, LocalDate.of(1991, 4, 14), address);
        this.employeeService.save(employee);

        // 01. Simple Mapping
        System.out.println(this.employeeService.getEmployeeView(employee));


        // 2. TypeMap mapping addresses and employees to ManagerDto with EmployeeDtos as subordinates
        List<Address> addresses = List.of(
                new Address("Bulgaria", "Sofia", "ul. G.S.Rakovski, 50"),
                new Address("Bulgaria", "Sofia", "Bul. Dondukov, 45"),
                new Address("Bulgaria", "Sofia", "ul. Hristo Smirnenski, 40"),
                new Address("Bulgaria", "Sofia", "bul. Alexander Malinov, 93a"),
                new Address("Bulgaria", "Sofia", "bul. Slivnitsa, 50"),
                new Address("Bulgaria", "Plovdiv", "ul. Angel Kanchev,34")
        );
        addresses.forEach(this.addressService::save);

        List<Employee> employees = List.of(
                new Employee("Steve", "Adams", 5780, LocalDate.of(1982, 3, 12),
                        addresses.get(0)),
                new Employee("Stephen", "Petrov", 2760, LocalDate.of(1974, 5, 19),
                        addresses.get(1)),
                new Employee("Hristina", "Petrova", 3680, LocalDate.of(1991, 11, 9),
                        addresses.get(1)),
                new Employee("Diana", "Atanasova", 6790, LocalDate.of(1989, 12, 9),
                        addresses.get(2)),
                new Employee("Samuil", "Georgiev", 4780, LocalDate.of(1979, 2, 10),
                        addresses.get(3)),
                new Employee("Slavi", "Hristov", 3780, LocalDate.of(1985, 2, 23),
                        addresses.get(4)),
                new Employee("Georgi", "Miladinov", 3960, LocalDate.of(1995, 3, 11),
                        addresses.get(5))
        );


        // Add managers and update employees
        employees.get(1).setManager(employees.get(0));
        employees.get(2).setManager(employees.get(0));

        employees.get(4).setManager(employees.get(3));
        employees.get(5).setManager(employees.get(3));
        employees.get(6).setManager(employees.get(3));

        employees.forEach(this.employeeService::save);

//        List<Employee> updated = created.stream().map(employeeService::updateEmployee).collect(Collectors.toList());
//
//        // Fetch all managers and map them to ManagerDto
//        TypeMap<Employee, ManagerDto> managerTypeMap = mapper.createTypeMap(Employee.class, ManagerDto.class)
//                .addMappings(m -> {
//                    m.map( Employee::getSubordinates, ManagerDto::setEmployees);
//                    m.map( src -> src.getAddress().getCity(), ManagerDto::setCity);
////                    m.skip(ManagerDto::setCity);
//                });
//        mapper.getTypeMap(Employee.class, EmployeeDto.class).addMapping(
//                src -> src.getAddress().getCity(), EmployeeDto::setCity
//        );
//        mapper.validate();
//
//        List<Employee> managers = employeeService.getAllManagers();
//        List<ManagerDto> managerDtos = managers.stream().map(managerTypeMap::map).collect(Collectors.toList());
//        managerDtos.forEach(System.out::println);
//
//        // 3. Employees born after 1990 with manager last name
//        Converter<String, String> converterNoManager = ctx -> ctx.getSource() == null ? "[No manager]" : ctx.getSource();
//
//        TypeMap employeeMap2 = mapper.getTypeMap(Employee.class, EmployeeDto.class)
//                .addMappings(m -> m.using(converterNoManager)
//                        .map(src -> src.getManager().getLastName(), EmployeeDto::setManagerLastName));
//
//
//
//        System.out.println("-".repeat(80) + "\n");
//        List<Employee> employeesBefore1990 = employeeService.getAllEmployeesBornBefore(LocalDate.of(1990, 1, 1));
////        employeesBefore1990.forEach(System.out::println);
//        employeesBefore1990.stream().map(employeeMap2::map).forEach(System.out::println);
    }
}
