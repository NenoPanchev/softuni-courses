import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Student> student = new ArrayList<>(4);

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);
            Student currentStudent = new Student();
            currentStudent.setFirstName(firstName);
            currentStudent.setLastName(lastName);
            currentStudent.setGrade(grade);
            student.add(currentStudent);
        }
        student.stream().sorted((p1, p2) -> Double.compare(p2.getGrade(), p1.getGrade()))
                .forEach(System.out::println);
    }
}
class Student {
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGrade() {
        return grade;
    }

    String firstName;
    String lastName;
    double grade;
    Student(){}

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
    }
}
