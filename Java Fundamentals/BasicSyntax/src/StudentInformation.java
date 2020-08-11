import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        double grade = Double.parseDouble(scan.nextLine());

        System.out.printf("Name: %s, ", name);
        System.out.printf("Age: %d, ", age);
        System.out.printf("Grade: %.2f", grade);
    }

}
