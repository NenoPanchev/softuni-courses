import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rooms = scan.nextLine().split("\\|");
        int healthPoints = 100;
        int bitcoins = 0;
        int bestroom = 0;

        for (String room : rooms) {
            String[] input = room.split("\\s+");
            String typeOfRoom = input[0];
            int value = Integer.parseInt(input[1]);
            bestroom++;

            switch (typeOfRoom) {
                case "potion":
                    int amountHealed = value;
                    if (healthPoints + value > 100) {
                        amountHealed = 100 - healthPoints;
                        healthPoints = 100;
                    } else
                        healthPoints += value;
                    System.out.printf("You healed for %d hp.%n", amountHealed);
                    System.out.printf("Current health: %d hp.%n", healthPoints);
                    break;

                case "chest":
                    System.out.printf("You found %d bitcoins.%n", value);
                    bitcoins += value;
                    break;

                default:
                    healthPoints -= value;
                    if (healthPoints > 0) {
                        System.out.printf("You slayed %s.%n", typeOfRoom);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", typeOfRoom);
                        System.out.printf("Best room: %d%n", bestroom);
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%n" +
                "Bitcoins: %d%n" +
                "Health: %d%n", bitcoins, healthPoints);
    }
}
