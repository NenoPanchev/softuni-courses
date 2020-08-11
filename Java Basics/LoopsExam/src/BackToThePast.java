import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalMoney = Double.parseDouble(scan.nextLine());
        int finalYear = Integer.parseInt(scan.nextLine());

        double moneySpent = 0;
        int years = 18;

        for (int i = 1800; i <= finalYear; i++){
            if (i % 2 == 0){
                moneySpent += 12000;
                years++;
            }
            else {
                moneySpent += (12000 + 50 * years);
                years++;
            }
        }
        double diff = Math.abs(moneySpent - totalMoney);
        if (totalMoney >= moneySpent)
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", diff);
        else System.out.printf("He will need %.2f dollars to survive.", diff);
    }
}
