import java.util.*;
import java.util.stream.Collectors;

public class Concert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        HashMap<String, LinkedHashSet<String>> bandMembers = new HashMap<>();
        TreeMap<String, Integer> bandTime = new TreeMap<>();

        while (!"start of concert".equals(input)) {
            String[] tokens = input.split(";\\s+");
            String command = tokens[0];
            String bandName = tokens[1];
            switch (command) {
                case "Add":
                    List<String> members = Arrays.stream(tokens[2].split(",\\s+")).collect(Collectors.toList());
                    bandMembers.putIfAbsent(bandName, new LinkedHashSet<>());
                    bandTime.putIfAbsent(bandName, 0);
                    for (String member : members) {
                        bandMembers.get(bandName).add(member);
                    }
                    break;

                case "Play":
                    bandTime.putIfAbsent(bandName, 0);
                    int time = Integer.parseInt(tokens[2]);
                    bandTime.put(bandName, bandTime.get(bandName) + time);
                    break;
            }

            input = scan.nextLine();
        }

        int totalTime = bandTime.values().stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Total time: %d%n", totalTime);
        bandTime
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(x -> System.out.printf("%s -> %d%n", x.getKey(), x.getValue()));

        String name = scan.nextLine();
        System.out.println(name);
        bandMembers
                .entrySet()
                .stream()
                .filter(band -> band.getKey().equals(name))
                .findFirst()
                .get()
                .getValue()
                .forEach(member -> System.out.printf("=> %s%n", member));
    }
}
