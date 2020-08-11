import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weekDays = Integer.parseInt(sc.nextLine());

        int workDays = 365 - weekDays;
        int workPlay = workDays * 63;
        int weekPlay = weekDays * 127;
        int totalPlay = weekPlay + workPlay;

        int minutes = Math.abs(totalPlay - 30000);
        int hoursLeft = minutes / 60;
        int minutesLeft = minutes % 60;
        if (totalPlay > 30000){
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hoursLeft, minutesLeft);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hoursLeft, minutesLeft);
        }
    }
}
