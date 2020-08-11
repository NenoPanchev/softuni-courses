import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printResult(Double.parseDouble(scan.nextLine()));
    }
    static void printResult(double grade) {
        if (grade >= 2 && grade < 3)
            System.out.println("Fail");
        else if (grade >= 3 && grade < 3.5)
            System.out.println("Poor");
        else if (grade >= 3.5 && grade < 4.5)
            System.out.println("Good");
        else if (grade >= 4.5 && grade < 5.5)
            System.out.println("Very good");
        else if (grade >= 5.5)
            System.out.println("Excellent");
    }
}
