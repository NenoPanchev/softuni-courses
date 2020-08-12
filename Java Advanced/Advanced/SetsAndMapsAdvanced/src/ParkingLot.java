import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String command = tokens[0];
            String carNumber = tokens[1];
            switch (command) {
                case "IN":
                    set.add(carNumber);
                    break;

                case "OUT":
                    set.remove(carNumber);
                    break;
            }
            input = scan.nextLine();
        }
        if (set.isEmpty())
            System.out.println("Parking Lot is Empty");
        else
            set.forEach(System.out::println);
    }
}
