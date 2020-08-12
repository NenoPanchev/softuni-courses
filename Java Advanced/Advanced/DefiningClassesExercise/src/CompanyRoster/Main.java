package CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Employee current = new Employee();
            current.setName(input[0]);
            current.setSalary(Double.parseDouble(input[1]));
            current.setPosition(input[2]);
            current.setDepartment(input[3]);

            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        current.setEmail(input[4]);
                    } else {
                        current.setAge(Integer.parseInt(input[4]));
                    }
                    break;
                case 6:
                    current.setEmail(input[4]);
                    current.setAge(Integer.parseInt(input[5]));
                    break;
            }
            employees.add(current);

        }
        List<String> departmentsList = employees.stream().map(Employee::getDepartment)
                .distinct().collect(Collectors.toList());

        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department, employees.stream().filter(employee ->
                    employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }
        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departments.get(0);
        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(),
                    employee.getAge());
        }
    }
}
