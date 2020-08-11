import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hoursNeeded = Integer.parseInt(sc.nextLine());
        int days = Integer.parseInt(sc.nextLine());
        int workers = Integer.parseInt(sc.nextLine());

        double actualDays = days * .9;
        double totalHours = Math.floor(actualDays * 10 * workers);
        double hoursDifference = Math.abs(hoursNeeded - totalHours);

        if (hoursNeeded <= totalHours){
            System.out.printf("Yes!%.0f hours left.", hoursDifference);
        } else
            System.out.printf("Not enough time!%.0f hours needed.", hoursDifference);
    }
}
