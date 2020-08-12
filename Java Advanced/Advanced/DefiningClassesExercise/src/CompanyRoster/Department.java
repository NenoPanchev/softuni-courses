package CompanyRoster;

import java.util.List;

public class Department {
    String name;
    List<Employee> employee;
    double avgSalary;

    public String getName() {
        return name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public Department(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().orElse(0);
    }
}
