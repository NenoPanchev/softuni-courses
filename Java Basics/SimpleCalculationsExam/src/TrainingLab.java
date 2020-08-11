import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double cols = (width - 1) / 0.7;
        double rows = length / 1.2;
        double total = Math.floor(cols)*Math.floor(rows)-3;
        System.out.printf("%.0f", total);
    }
}
