import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
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
            boolean same = false;
            for (int i = 0; i < student.size(); i++) {
                if (isSameStudent(student.get(i).firstName, student.get(i).lastName, firstName, lastName)) {
                    student.set(i, currentStudent);
                    same = true;
                }
            }
            if (!same)
            student.add(currentStudent);

            input = scan.nextLine();
        }

        String town = scan.nextLine();

        for (int i = 0; i < student.size(); i++) {
            if (town.equals(student.get(i).hometown))
                System.out.printf("%s %s is %s years old%n", student.get(i).firstName, student.get(i).lastName, student.get(i).age);
        }
    }


    static class Student {
        String firstName;
        String lastName;
        String age;
        String hometown;

    }

    static boolean isSameStudent(String firstName1, String lastName1, String firstName2, String lastName2) {
        if (firstName1.equals(firstName2) && lastName1.equals(lastName2)) return true;
        else {
            return false;
        }
    }
}