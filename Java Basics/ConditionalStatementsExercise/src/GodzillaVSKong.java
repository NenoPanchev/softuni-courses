import java.util.Scanner;

public class GodzillaVSKong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double budget = Double.parseDouble(sc.nextLine());
        int stunts = Integer.parseInt(sc.nextLine());
        double priceClothes = Double.parseDouble(sc.nextLine());

        budget *= 0.9;
        double totalStuntPrice = stunts * priceClothes;

        if (stunts > 150){
            totalStuntPrice *= 0.9;
        }

        if (totalStuntPrice > budget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", (totalStuntPrice - budget));
        }
        else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", (budget - totalStuntPrice));
        }

    }
}
