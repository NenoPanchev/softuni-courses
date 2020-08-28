import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> set = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!"Print".equals(input)) {
            String[] split = input.split("\\s+filter;");
            String command = split[0];
            if (command.equals("Add")) {
                set.add(split[1]);
            } else {
                set.remove(split[1]);
            }
            input = scan.nextLine();
        }
        for (String predicateString : set) {
            String[] tokens = predicateString.split(";");
            String condition = tokens[0];
            String sub = tokens[1];
            Predicate<String> predicate = s -> {
                switch (condition) {
                    case "Starts with":
                        return s.startsWith(sub);

                    case "Ends with":
                        return s.endsWith(sub);

                    case "Contains":
                        return s.contains(sub);

                    default:
                        return s.length() == Integer.parseInt(sub);
                }
            };
            if (list.size() > 0) {
                UnaryOperator<List<String>> listFilter = list1 -> list1.stream().filter(predicate.negate()).collect(Collectors.toList());
                list = listFilter.apply(list);
            }
        }
        if (list.size() > 0)
        list.forEach(s -> System.out.printf("%s ", s));
    }
}
