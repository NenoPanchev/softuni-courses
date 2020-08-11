import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dogs = Integer.parseInt(scan.nextLine());
        int others = Integer.parseInt(scan.nextLine());
        double priceA = dogs * 2.5;
        double priceB = others * 4;
        double sum = priceA + priceB;
        System.out.printf("%.2f lv.", sum);
    }
}
