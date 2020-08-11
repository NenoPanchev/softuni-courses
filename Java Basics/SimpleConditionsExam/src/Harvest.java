import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int area = Integer.parseInt(sc.nextLine());
        double grapePerArea = Double.parseDouble(sc.nextLine());
        int wineNeeded = Integer.parseInt(sc.nextLine());
        int workers = Integer.parseInt(sc.nextLine());

        double totalGrape = area * grapePerArea * .4;
        double totalWine = totalGrape / 2.5;
        double wineDifference = Math.max(totalWine, wineNeeded) - Math.min(totalWine, wineNeeded);
        double winePerPerson = wineDifference / workers;
        if (wineNeeded > totalWine){
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineDifference));
        } else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.", Math.floor(totalWine));
            System.out.println();
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wineDifference),Math.ceil(winePerPerson));
        }
    }
}

