import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double moneyNeeded = Double.parseDouble(scan.nextLine());
        int num = Integer.parseInt(scan.nextLine());
        double totalMoney = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0 && i != 1)
                totalMoney *= 0.84;
            if (i % 4 == 0)
                totalMoney *= 1.25;
            totalMoney += moneyNeeded * 0.25;
        }
        if (totalMoney >= moneyNeeded)
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.%n",
                    totalMoney - moneyNeeded);
        else
            System.out.printf("Sorry. You need %.2flv. more.%n", moneyNeeded - totalMoney);
    }
}
