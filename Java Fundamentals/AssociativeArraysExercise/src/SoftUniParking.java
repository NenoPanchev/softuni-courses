import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, String> personsCar = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("register")) {
                if (personsCar.containsKey(tokens[1])) {
                    System.out.printf("ERROR: already registered with plate number %s%n", personsCar.get(tokens[1]));
                } else {
                    personsCar.put(tokens[1], tokens[2]);
                    System.out.printf("%s registered %s successfully%n", tokens[1], personsCar.get(tokens[1]));
                }
            } else if (tokens[0].equals("unregister")) {
                if (!personsCar.containsKey(tokens[1])) {
                    System.out.printf("ERROR: user %s not found%n", tokens[1]);
                } else {
                    System.out.printf("%s unregistered successfully%n", tokens[1]);
                    personsCar.remove(tokens[1]);
                }

            }
        }
        personsCar.entrySet()
                .forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));

    }
}
