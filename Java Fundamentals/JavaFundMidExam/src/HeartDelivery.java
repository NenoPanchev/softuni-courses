import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> houses = Arrays.stream(scan.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();
        int lastPosition = 0;

        while (!input.equals("Love!")) {
            String[] token = input.split("\\s+");
            int length = Integer.parseInt(token[1]);
            lastPosition += length;
            if (lastPosition >= houses.size())
                lastPosition = 0;

            int currentHouseValue = houses.get(lastPosition);

            if (currentHouseValue > 2)
                houses.set(lastPosition, currentHouseValue - 2);
            else if (currentHouseValue == 1 || currentHouseValue == 2) {
                houses.set(lastPosition, 0);
                System.out.printf("Place %d has Valentine's day.%n", lastPosition);
            } else if (currentHouseValue == 0)
                System.out.printf("Place %d already had Valentine's day.%n", lastPosition);

            input = scan.nextLine();
        }
        int failedPlaces = 0;
        for (Integer house : houses) {
            if (house != 0)
                failedPlaces ++;
        }
        System.out.printf("Cupid's last position was %d.%n", lastPosition);
        if (failedPlaces == 0)
            System.out.println("Mission was successful.");
        else
        System.out.printf("Cupid has failed %d places.%n", failedPlaces);
    }
}
