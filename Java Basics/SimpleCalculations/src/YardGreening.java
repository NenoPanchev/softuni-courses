import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = Double.parseDouble(scan.nextLine());
        double fullPrice = num * 7.61;
        double finalPrice = fullPrice * 0.82;
        double discount = fullPrice * 0.18;
        System.out.printf("The final price is: %.2f lv.", finalPrice);
        System.out.println();
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}
