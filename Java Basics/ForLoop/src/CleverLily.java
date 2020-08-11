import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = Integer.parseInt(scan.nextLine());
        double machinePrice = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());

        int savedMoney = 0;
        int birthdayMoney = 10;

        for (int i = 1; i <= age; i++){
            if (!(i % 2 == 0)){
                savedMoney = savedMoney + toyPrice;
            } else {
                savedMoney = savedMoney + birthdayMoney - 1;
                birthdayMoney += 10;
            }

        }
        double diff = Math.abs(savedMoney - machinePrice);
        if (savedMoney >= machinePrice)
            System.out.printf("Yes! %.2f", diff);
        else System.out.printf("No! %.2f", diff);
    }
}
