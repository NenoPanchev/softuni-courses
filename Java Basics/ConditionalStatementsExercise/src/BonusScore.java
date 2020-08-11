import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        double bonusHundreds = 0.0;
        double bonusOdd = 0.0;

        if (number <= 100) {
            bonusHundreds = 5;
        } else if (number <= 1000) {
            bonusHundreds = number * 0.2;
        } else if (number > 1000) {
            bonusHundreds = number * 0.1;
        }

        if (number % 2 == 0){
            bonusOdd = 1;
        } else if (number % 5 == 0){
            bonusOdd = 2;
        }
        System.out.println(bonusHundreds + bonusOdd);
        System.out.println(number + bonusHundreds + bonusOdd);
    }
}
