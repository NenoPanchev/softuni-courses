import java.util.Scanner;

public class ChristmasMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double moneyWanted = Double.parseDouble(scan.nextLine());
        int fantasy = Integer.parseInt(scan.nextLine());
        int horror = Integer.parseInt(scan.nextLine());
        int romantic = Integer.parseInt(scan.nextLine());
        double forSellers = 0;
        double donated = 0;

        double beforeVAC = fantasy * 14.9 + horror * 9.8 + romantic * 4.3;
        double afterVac = beforeVAC * .8;

        if (afterVac >= moneyWanted){
            forSellers = Math.floor((afterVac - moneyWanted) * .1);
            donated = afterVac - forSellers;
            System.out.printf("%.2f leva donated.%n", donated);
            System.out.printf("Sellers will receive %.0f leva.", forSellers);
        } else
            System.out.printf("%.2f money needed.", moneyWanted - afterVac);
    }
}
