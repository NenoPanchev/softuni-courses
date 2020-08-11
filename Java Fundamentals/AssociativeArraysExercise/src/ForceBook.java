import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, List<String>> sideUsers = new TreeMap<>();
        String input = scan.nextLine();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains(" | ")) {
                String[] tokens = input.split("\\s+\\|\\s+");
                String side = tokens[0];
                String user = tokens[1];
                sideUsers.putIfAbsent(side, new ArrayList<>());
                boolean exist = false;
                for (Map.Entry<String, List<String>> entry : sideUsers.entrySet()) {
                    if (entry.getValue().contains(user))
                        exist = true;
                }
                if (!exist)
                    sideUsers.get(side).add(user);

            } else if (input.contains(" -> ")) {
                String[] tokens = input.split("\\s+->\\s+");
                String side = tokens[1];
                String user = tokens[0];
                for (Map.Entry<String, List<String>> entry : sideUsers.entrySet()) {
                    entry.getValue().remove(user);
                }
                sideUsers.putIfAbsent(side, new ArrayList<>());
                sideUsers.get(side).add(user);
                System.out.printf("%s joins the %s side!%n", user, side);
            } else continue;

            input = scan.nextLine();
        }
        sideUsers.entrySet()
                .stream()
                .filter(e -> e.getValue().size() >= 1)
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.printf("! %s%n", s));
                });
    }
}
