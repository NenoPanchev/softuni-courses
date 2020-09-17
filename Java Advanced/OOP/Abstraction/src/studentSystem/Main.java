package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();
        while (!input.equals("Exit")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String name = tokens[1];
            if (command.equals("Create")) {
                int age = Integer.parseInt(tokens[2]);
                double grade = Double.parseDouble(tokens[3]);
                Student student = new Student(name, age, grade);
                studentSystem.addStudentIfNameNotPresent(student);
            } else if (command.equals("Show")) {
                studentSystem.printDataOfStudentWith(name);
            }
            input = scanner.nextLine();
        }
    }
}
