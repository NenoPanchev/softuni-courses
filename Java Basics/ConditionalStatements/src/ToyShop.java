import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double vacation = Double.parseDouble(scan.nextLine());
        int puzzles = Integer.parseInt(scan.nextLine());
        int dolls = Integer.parseInt(scan.nextLine());
        int bears = Integer.parseInt(scan.nextLine());
        int minions = Integer.parseInt(scan.nextLine());
        int trucks = Integer.parseInt(scan.nextLine());

        double total = puzzles * 2.6 + dolls * 3 + bears * 4.1 + minions * 8.2 + trucks * 2;
        int count = puzzles + dolls + bears + minions + trucks;
        if (count >= 50) {
            total = total * 0.75;
        }
        double money = total * 0.90;
        if (money >= vacation) {
            double result = money - vacation;
            System.out.printf("Yes! %.2f lv left.", result);
        } else {
            double result = vacation - money;
            System.out.printf("Not enough money! %.2f lv needed.", result);
        }
    }
}
