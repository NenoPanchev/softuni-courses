import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Engine implements Runnable{
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Hello, fellow student :)");

        while (true) {
            System.out.println("Enter the number of problem you wish to check or 0 to exit:");
            int problem = 0;

            try {
                problem = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                switch (problem) {
                    case 0:
                        System.out.println("Goodbye! :)");
                        System.exit(0);
                    case 2:
                        changeCasingEx2();
                        break;
                    case 3:
                        containsEmployeeEx3();
                        break;
                    case 4:
                        employeesWithSalaryOver50000Ex4();
                        break;
                    case 5:
                        employeesFromDepartmentEx5();
                        break;
                    case 6:
                        addingANewAddressAndUpdatingEmployeeEx6();
                        break;
                    case 7:
                        addressesWithEmployeeCountEx7();
                        break;
                    case 8:
                        getEmployeeWithProjectEx8();
                        break;
                    case 9:
                        findLatestTenProjectsEx9();
                        break;
                    case 10:
                        increaseSalariesEx10();
                        break;
                    case 11:
                        findEmployeesByFirstNameEx11();
                        break;
                    case 12:
                        employeesMaximumSalariesEx12();
                        break;
                    case 13:
                        removeTownsEx13();
                        break;
                    default:
                        System.out.println("Incorrect number. Try again.");
                }
            } catch (IndexOutOfBoundsException | IOException e) {

            }
            System.out.println();
        }
    }

    private void changeCasingEx2() {
        List<Town> towns = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE length(t.name) <= 5 ", Town.class)
                .getResultList();

        entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toUpperCase());
        }
        towns.forEach(entityManager::merge);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    private void containsEmployeeEx3() throws IOException {
        System.out.println("Enter employee full name:");
        String fullName = reader.readLine();
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE concat(e.firstName, ' ', e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();
        System.out.println(employees.size() == 0 ? "No" : "Yes");
    }


    private void employeesWithSalaryOver50000Ex4() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void employeesFromDepartmentEx5() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id = 6 " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s from Research and Development - $%.2f%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary()));
    }

    private void addingANewAddressAndUpdatingEmployeeEx6() throws IOException {


        try {
            Address address = createAddress("Vitoshka 15");
            System.out.println("Enter employee's last name to update their address:");
            String lastName = reader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :name", Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();
            entityManager.getTransaction().begin();
            employee.setAddress(address);
            address.getEmployees().add(employee);
            entityManager.getTransaction().commit();

        } catch (NoResultException noResultException) {
            System.out.println("No such employee.");
        }
    }

    private void addressesWithEmployeeCountEx7() {
        entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(address -> System.out.printf("%s, %s - %d employees%n",
                        address.getText(),
                        address.getTown().getName(),
                        address.getEmployees().size()));
    }

    private void getEmployeeWithProjectEx8() throws IOException {
        System.out.println("Enter employee ID to get their info:");
        int employeeId = Integer.parseInt(reader.readLine());

        Employee employee = entityManager
                .find(Employee.class, employeeId);
        if (employee == null) {
            System.out.println("Employee with that ID does not exist");
            return;
        }
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("\t%s%n", project.getName()));
    }

    private void findLatestTenProjectsEx9() {
        entityManager
                .createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    System.out.printf("Project name: %s%n" +
                                    "\tProject Description: %s%n" +
                                    "\tProject Start Date: %s%n" +
                                    "\tProject End Date: %s%n",
                            project.getName(),
                            project.getDescription(),
                            project.getStartDate().format(formatter),
                            project.getEndDate());
                });
    }

    private void increaseSalariesEx10() {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultList();

        entityManager.getTransaction().begin();
        employees.forEach(employee -> employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.12"))));
        entityManager.getTransaction().commit();

        employees.forEach(employee -> System.out.printf("%s %s ($%.2f)%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary()));
    }

    private void findEmployeesByFirstNameEx11() throws IOException {
        System.out.println("Enter pattern to print all employees whose first name starts with it:");
        String pattern = reader.readLine();

        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getJobTitle(),
                        employee.getSalary()));
    }

    private void employeesMaximumSalariesEx12() {
        List<Object[]> resultList = entityManager
                .createQuery("SELECT e.department.name, MAX(e.salary) FROM Employee e " +
                        "GROUP BY e.department.id " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList();

        for (Object[] objects : resultList) {
            System.out.printf("%s %.2f%n",
                    objects[0],
                    objects[1]
            );
        }

    }

    private void removeTownsEx13() throws IOException {
        System.out.println("Enter town you wish to delete:");
        String townName = reader.readLine();
        Town town = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :name", Town.class)
                .setParameter("name", townName)
                .getSingleResult();
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.id = :townId", Address.class)
                .setParameter("townId", town.getId())
                .getResultList();
        int affected = addresses.size();

        entityManager.getTransaction().begin();
        addresses
                .forEach(address -> address.getEmployees()
                .forEach(employee -> employee.setAddress(null)));
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Integer affectedAddresses = entityManager
                .createQuery("DELETE FROM Address a " +
                        "WHERE a.town.id = :townId")
                .setParameter("townId", town.getId())
                .executeUpdate();

        entityManager
                .createQuery("DELETE FROM Town t " +
                        "WHERE t.name = :name")
                .setParameter("name", townName)
                .executeUpdate();

        entityManager.getTransaction().commit();

        System.out.print(affectedAddresses + " ");
        System.out.print(affectedAddresses == 1 ? "address " : "addresses ");
        System.out.printf("in %s deleted%n", townName);
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);
        Town town = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = 'Sofia'", Town.class)
                .getSingleResult();
        address.setTown(town);
        address.setEmployees(new HashSet<>());

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

}
