import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int counter = 0;
        while (!command.equals("End of battle")) {
            int energy = Integer.parseInt(command);
            if (initialEnergy - energy >= 0) {
                initialEnergy -= energy;
                counter++;
                if (counter % 3 == 0) {
                    initialEnergy += counter;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n",
                        counter, initialEnergy);
                return;
            }
            command = scan.nextLine();
        }

        System.out.printf("Won battles: %d. Energy left: %d%n", counter, initialEnergy);
    }
}
