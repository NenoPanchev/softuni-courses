import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, ArrayList<String>> userMessages = new TreeMap<>();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add":
                    if (userMessages.containsKey(username))
                        System.out.printf("%s is already registered%n", username);
                    else
                        userMessages.put(username, new ArrayList<>());
                    break;

                case "Send":
                    String message = tokens[2];
                    userMessages.get(username).add(message);
                    break;

                case "Delete":
                    if (userMessages.containsKey(username))
                        userMessages.remove(username);
                    else
                        System.out.printf("%s not found!%n", username);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Users count: %d%n", userMessages.size());
        userMessages
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().forEach(email -> System.out.printf("- %s%n", email));
                });
    }
}
