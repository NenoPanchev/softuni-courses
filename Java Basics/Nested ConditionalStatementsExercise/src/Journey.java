import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        double percent = 1;
        String sleeping = "";
        String country = "";

        if (budget <= 100){
            country = "Bulgaria";
            if (season.equals("summer")) {
                percent = .3;
                sleeping = "Camp";
            }
            else {
                percent = .7;
                sleeping = "Hotel";
            }
        } else if (budget <= 1000){
            country = "Balkans";
            if (season.equals("summer")) {
                percent = .4;
                sleeping = "Camp";
            }
            else {
                percent = .8;
                sleeping = "Hotel";
            }
        } else {
            country = "Europe";
            percent = .9;
            sleeping = "Hotel";
        }
        System.out.printf("Somewhere in %s", country);
        System.out.println();
        System.out.printf(("%s - %.2f"), sleeping, (budget * percent));
    }
}
