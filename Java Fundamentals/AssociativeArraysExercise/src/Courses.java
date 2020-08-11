import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, List<String>> courseStudents = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            courseStudents.putIfAbsent(tokens[0], new ArrayList<>());
            courseStudents.get(tokens[0]).add(tokens[1]);
            input = scan.nextLine();
        }

        courseStudents.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.printf("-- %s%n", s));
                });

    }
}
