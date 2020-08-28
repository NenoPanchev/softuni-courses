import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String input = scan.nextLine();
        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String condition = tokens[1];

            Predicate<String> checkCondition = s -> {
            switch (condition) {
                case "StartsWith":
                    return s.startsWith(tokens[2]);

                case "EndsWith":
                    return s.endsWith(tokens[2]);

                default:
                    return s.length() == Integer.parseInt(tokens[2]);
            }
            };

            Consumer<List<String>> listConsumer = list1 -> {
                if (command.equals("Double")) {
                    for (int i = 0; i < list1.size(); i++) {
                        if (checkCondition.test(list1.get(i))) {
                            list1.add(0, list1.get(i));
                            i++;
                        }
                    }

                } else {
                    for (int i = 0; i < list1.size(); i++) {
                        if (checkCondition.test(list1.get(i))) {
                            list1.remove(list1.get(i));
                            i--;
                        }
                    }
                }
            };
            listConsumer.accept(list);


            input = scan.nextLine();
        }
        if (list.size() > 0) {
            Collections.sort(list);
            System.out.print(String.join(", ", list));
            System.out.println(" are going to the party!");
        } else
            System.out.println("Nobody is going to the party!");
    }
}
