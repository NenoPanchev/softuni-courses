import java.util.Scanner;

public class SkiEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        double skiPrice = Double.parseDouble(scan.nextLine());
        double sticksPrice = Double.parseDouble(scan.nextLine());

        double shoesPrice = skiPrice * 0.4;
        double clothesPrice = skiPrice * 1.4;

        double allButSticksPrice = skiPrice + shoesPrice + clothesPrice;
        if (allButSticksPrice > 800) sticksPrice = 0;
        double totalPrice = allButSticksPrice + sticksPrice;

        if (budget >= totalPrice) {
            System.out.printf("Angel's sum is %.2f lv. He has %.2f lv. left.", totalPrice, budget - totalPrice);
        } else
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - budget);
    }
}
