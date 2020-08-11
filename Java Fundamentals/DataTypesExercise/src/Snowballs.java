import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        long bestValue = 0;
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;

        for (int i = 1; i <= num; i++){
            int snow = Integer.parseInt(scan.nextLine());
            int time = Integer.parseInt(scan.nextLine());
            int quality = Integer.parseInt(scan.nextLine());
            long value = (long) Math.pow((1. * snow / time), quality);
            if (value > bestValue) {
                bestValue = value;
                bestSnow = snow;
                bestTime = time;
                bestQuality = quality;
            }
        }
        System.out.printf("%d : %d = %d (%d)", bestSnow, bestTime, bestValue, bestQuality);
    }
}
