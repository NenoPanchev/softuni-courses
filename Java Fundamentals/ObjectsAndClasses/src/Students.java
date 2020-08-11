import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> student = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("end")) {
            String[] person = input.split("\\s+");
            String firstName = person[0];
            String lastName = person[1];
            String age = person[2];
            String hometown = person[3];

            Student currentStudent = new Student();
            currentStudent.firstName = firstName;
            currentStudent.lastName = lastName;
            currentStudent.age = age;
            currentStudent.hometown = hometown;
            student.add(currentStudent);

            input = scan.nextLine();
        }

        String town = scan.nextLine();

        for (int i = 0; i < student.size(); i++) {
            if (town.equals(student.get(i).hometown))
                System.out.printf("%s %s is %s years old%n", student.get(i).firstName, student.get(i).lastName, student.get(i).age);
        }
    }
}
class Student {
    String firstName;
    String lastName;
    String age;
    String hometown;

}