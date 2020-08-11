import java.util.Scanner;

public class FriendlistMaintenance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(",\\s+");
        String input = scan.nextLine();

        while (!"Report".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Blacklist":
                    String name = tokens[1];
                    lookToBlacklist(array, name);
                    break;

                case "Error":
                    int index = Integer.parseInt(tokens[1]);
                    if (isLost(array, index)) {
                        System.out.printf("%s was lost due to an error.%n", array[index]);
                        array[index] = "Lost";
                    }
                    break;

                case "Change":
                    index = Integer.parseInt(tokens[1]);
                    String newName = tokens[2];
                    checkAndChange(array, index, newName);
                    break;
            }
            input = scan.nextLine();
        }
        int lost = 0;
        int blacklisted = 0;
        for (String s : array) {
            if (s.equals("Lost"))
                lost++;
            if (s.equals("Blacklisted"))
                blacklisted++;
        }
        System.out.printf("Blacklisted names: %d%n", blacklisted);
        System.out.printf("Lost names: %d%n", lost);
        System.out.println(String.join(" ", array));
    }

    private static void lookToBlacklist(String[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(name)) {
                arr[i] = "Blacklisted";
                System.out.printf("%s was blacklisted.%n", name);
                return;
            }
        }
        System.out.printf("%s was not found.%n", name);
    }

    private static boolean isLost(String[] arr, int index) {
        return (!arr[index].equals("Blacklisted") && !arr[index].equals("Lost"));
    }

    private static void checkAndChange(String[] arr, int index, String newName) {
        if (index >= 0 && index < arr.length) {
            System.out.printf("%s changed his username to %s.%n", arr[index], newName);
            arr[index] = newName;
        }
    }
}
