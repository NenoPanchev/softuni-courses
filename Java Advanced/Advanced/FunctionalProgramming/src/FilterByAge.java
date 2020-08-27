import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Map<String, Integer> personAge = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split(",\\s+");
            personAge.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        String ageCondition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String printCondition = scan.nextLine();

        Predicate<Integer> filterByAge = pAge -> {
             switch (ageCondition) {
                 case "older":
                     return pAge >= age;
                 default:
                     return pAge <= age;
            }
        };

        Function<Map.Entry<String, Integer>, String> parsePersonToString = x -> {
            String print = "";
            switch (printCondition) {
                case "name":
                    print = x.getKey();
                    break;

                case "age":
                    print = x.getValue().toString();
                    break;

                default: print = x.getKey() + " - " + x.getValue();
            }
            return print;
        };

        personAge.entrySet().stream()
                .filter(x -> filterByAge.test(x.getValue()))
                .map(parsePersonToString)
                .forEach(System.out::println);
    }
}
