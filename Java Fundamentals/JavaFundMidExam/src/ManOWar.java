import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxHealthOfSection = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!command.equals("Retire")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Fire":
                subtractEnemyIndex(warShip, command);
                break;

                case "Defend":
                subtractOwnIndexes(pirateShip, command);
                break;

                case "Repair":
                addHealthToIndex(pirateShip, command, maxHealthOfSection);
                break;

                case "Status":
                printLowSectors(pirateShip, maxHealthOfSection);
                break;
            }
            if (isShipSunk(warShip) || isShipSunk(pirateShip))
                return;
            command = scan.nextLine();
        }
        System.out.printf("Pirate ship status: %d%n", getStatusSum(pirateShip));
        System.out.printf("Warship status: %d%n", getStatusSum(warShip));

    }

    static void subtractEnemyIndex(List<Integer> list, String command) {
        String[] tokens = command.split("\\s+");
        int index = Integer.parseInt(tokens[1]);
        int damage = Integer.parseInt(tokens[2]);
        if (index >= 0 && index < list.size()) {
            if (list.get(index) - damage > 0)
                list.set(index, list.get(index) - damage);
            else {
                System.out.println("You won! The enemy ship has sunken.");
                list.set(index, 0);
                return;
            }
        }
    }
    static void subtractOwnIndexes(List<Integer> list, String command) {
        String[] tokens = command.split("\\s+");
        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);
        int damage = Integer.parseInt(tokens[3]);
        if (startIndex >= 0 && endIndex < list.size()) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (list.get(i) - damage > 0)
                    list.set(i, list.get(i) - damage);
                else {
                    System.out.println("You lost! The pirate ship has sunken.");
                    list.set(i, 0);
                    return;
                }
            }
        }
    }
    static void addHealthToIndex(List<Integer> list, String command, int maxHealth) {
        String[] tokens = command.split("\\s+");
        int index = Integer.parseInt(tokens[1]);
        int health = Integer.parseInt(tokens[2]);
        if (index >= 0 && index < list.size()) {
            int newHealth = list.get(index) + health;
            if (newHealth > maxHealth)
                newHealth = maxHealth;
            list.set(index, newHealth);
        }
    }
    static void printLowSectors(List<Integer> list, int maxHealth) {
        int counter = 0;
        for (Integer integer : list) {
            if (integer < maxHealth * 0.2)
                counter++;
        }
        System.out.printf("%d sections need repair.%n", counter);
    }
    static int getStatusSum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
    static boolean isShipSunk(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0)
                return true;
        }
        return false;
    }
}
