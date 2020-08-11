import java.util.Scanner;


public class NationalCourt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int people = Integer.parseInt(scan.nextLine());
        int nonStopHours = people / (first + second + third);
        if (people % (first + second + third) != 0)
            nonStopHours += 1;
        int rest = 0;
        for (int i = 0; i < nonStopHours; i++) {
            if (i % 3 == 0 && i != 0)
                rest++;
        }
        int neededTime = nonStopHours + rest;

        System.out.printf("Time needed: %dh.%n", neededTime);
    }
}
