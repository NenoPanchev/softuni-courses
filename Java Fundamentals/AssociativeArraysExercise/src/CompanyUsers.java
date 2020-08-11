import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, List<String>> companyEmployees = new TreeMap<>();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String employeesID = tokens[1];
            companyEmployees.putIfAbsent(company, new ArrayList<>());
            if (!companyEmployees.get(company).contains(employeesID))
                companyEmployees.get(company).add(employeesID);
            input = scan.nextLine();
        }

        companyEmployees.entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}
