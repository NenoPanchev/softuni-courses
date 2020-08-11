import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double neededMoney = Double.parseDouble(scan.nextLine());
        double currentMoney = Double.parseDouble(scan.nextLine());
        int daysCounter = 0;
        int spendingCounter = 0;

        while (currentMoney < neededMoney && spendingCounter < 5) {
            String input = scan.nextLine();
            double transaction = Double.parseDouble(scan.nextLine());
            daysCounter++;
            if (input.equals("save")) {
                currentMoney += transaction;
                spendingCounter = 0;

                if (currentMoney >= neededMoney) {
                    break;
                }
            } else if (input.equals("spend")) {
                currentMoney -= transaction;
                spendingCounter++;
                if (currentMoney < 0) {
                    currentMoney = 0;
                }
            }
        }
        if (currentMoney >= neededMoney)
            System.out.printf("You saved the money for %d days.", daysCounter);
        if (spendingCounter == 5) {
            System.out.println("You can't save the money.");
            System.out.println(daysCounter);
        }

    }
}
