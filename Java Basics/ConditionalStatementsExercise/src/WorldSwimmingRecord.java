import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double record = Double.parseDouble(sc.nextLine());
        double length = Double.parseDouble(sc.nextLine());
        double secondsPerMeter = Double.parseDouble(sc.nextLine());

        double seconds = length * secondsPerMeter;
        double bonusSeconds = (Math.floor(length / 15)) * 12.5;
        seconds += bonusSeconds;

        if (seconds < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", seconds);
        }
        else
            System.out.printf("No, he failed! He was %.2f seconds slower.", (seconds - record));
    }
}
