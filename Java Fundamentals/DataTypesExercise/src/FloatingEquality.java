import java.sql.SQLOutput;
import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
        double first = Double.parseDouble(scan.nextLine());
        double second = Double.parseDouble(scan.nextLine());
        double difference = Math.abs(first - second);
        if (difference < 0.000001) System.out.println("True");
        else System.out.println("False");

    }
}
