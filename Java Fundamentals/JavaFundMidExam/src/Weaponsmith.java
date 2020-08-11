import java.util.Scanner;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] weapon = scan.nextLine().split("\\|");
        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String specifier = tokens[1];
            switch (command) {
                case "Move":
                    int index = Integer.parseInt(tokens[2]);
                    int otherIndex = 1;
                    if (specifier.equals("Left"))
                        otherIndex = -1;
                    if (isPossible(weapon, index + otherIndex)) {
                        moveParticleAtSaidDirection(weapon, index, otherIndex);
                    }
                    break;

                case "Check":
                    printOddOrEvenElements(weapon, specifier);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("You crafted %s!%n", String.join("", weapon));
    }

    private static void printOddOrEvenElements(String[] weapon, String specifier) {
        if (specifier.equals("Even")) {
            for (int i = 0; i < weapon.length; i++) {
                if (i % 2 == 0)
                    System.out.printf("%s ", weapon[i]);
            }
        } else {
            for (int i = 0; i < weapon.length; i++) {
                if (i % 2 != 0)
                    System.out.printf("%s ", weapon[i]);
            }
        }
        System.out.println();
    }

    private static void moveParticleAtSaidDirection(String[] weapon, int index, int otherIndex) {
        String swap = weapon[index];
        weapon[index] = weapon[index + otherIndex];
        weapon[index + otherIndex] = swap;
    }

    private static boolean isPossible(String[] weapon, int index) {
        return (index >= 0 && index < weapon.length);
    }
}
