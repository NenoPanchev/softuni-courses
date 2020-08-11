import java.util.Scanner;

public class BackIn30Mins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());

        minutes += 30;
        if (minutes >= 60) {
            hours++;
            minutes -= 60;
        }
        if (hours > 23) hours = 0;

        if (minutes < 10)
            System.out.printf("%d:0%d", hours, minutes);
        else System.out.printf("%d:%d", hours, minutes);
    }
}
