import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String leap = scan.nextLine();
        int holidays = Integer.parseInt(scan.nextLine());
        int homeDays = Integer.parseInt(scan.nextLine());
        double holidayPlay = holidays * 2.0 / 3;
        double sofiaPlay = (48 - homeDays) * 3.0 / 4;
        double bonus = 1;
        if (leap.equals("leap"))
            bonus = 1.15;
        else if (leap.equals("normal"))
            bonus = 1;
        System.out.printf("%.0f", Math.floor((holidayPlay + sofiaPlay + homeDays) * bonus));
    }
}
