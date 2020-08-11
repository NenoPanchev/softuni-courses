import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int chefs = Integer.parseInt(scan.nextLine());
        int cakes = Integer.parseInt(scan.nextLine());
        int waffles = Integer.parseInt(scan.nextLine());
        int pancakes = Integer.parseInt(scan.nextLine());
        double fullPrice = days * (chefs * cakes * 45 + chefs * waffles * 5.8 + chefs * pancakes * 3.2);
        double finalPrice = fullPrice - fullPrice / 8;
        System.out.printf("%.2f", finalPrice);
    }
}
