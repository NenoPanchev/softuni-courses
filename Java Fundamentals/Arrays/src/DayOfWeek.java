import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int num = Integer.parseInt(scan.nextLine());
        if (num >= 1 && num <= 7)
            System.out.println(day[num - 1]);
        else
            System.out.println("Invalid day!");

    }
}
