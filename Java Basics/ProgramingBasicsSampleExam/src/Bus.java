import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int passengers = Integer.parseInt(scan.nextLine());
        int stops = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= stops; i++) {
            int goingPassengers = Integer.parseInt(scan.nextLine());
            int incomingPassengers = Integer.parseInt(scan.nextLine());

            passengers += incomingPassengers;
            passengers -= goingPassengers;

            if (!(i % 2 == 0))
                passengers += 2;
            else passengers -= 2;
        }

        System.out.printf("The final number of passengers is : %d", passengers);
    }
}
