import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, Integer> userLikes = new TreeMap<>();
        TreeMap<String, Integer> userComments = new TreeMap<>();
        while (!input.equals("Log out")) {
            String[] tokens = input.split(":\\s+");
            String username = tokens[1];
            switch (tokens[0]) {
                case "New follower":
                    userLikes.putIfAbsent(username, 0);
                    userComments.putIfAbsent(username, 0);
                    break;
                case "Like":
                    userLikes.putIfAbsent(username, 0);
                    userComments.putIfAbsent(username, 0);
                    userLikes.put(username, userLikes.get(username) + Integer.parseInt(tokens[2]));
                    break;
                case "Comment":
                    userLikes.putIfAbsent(username, 0);
                    userComments.putIfAbsent(username, 0);
                    userComments.put(username, userComments.get(username) + 1);
                    break;
                case "Blocked":
                    if (userLikes.containsKey(username)) {
                        userLikes.remove(username);
                        userComments.remove(username);
                    } else
                        System.out.printf("%s doesn't exist.%n", username);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("%d followers%n", userLikes.size());
        userLikes.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(s -> {
                    String name = s.getKey();
                    System.out.printf("%s: %d%n", s.getKey(), s.getValue() + userComments.get(name));
                });
    }
}
