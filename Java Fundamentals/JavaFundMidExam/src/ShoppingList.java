import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> groceries = Arrays.stream(scan.nextLine().split("!"))
                .collect(Collectors.toList());
        String input = scan.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] token = input.split("\\s+");
            String command = token[0];
            String item = token[1];

            switch (command) {
                case "Urgent":
                    if (!exists(groceries, item))
                        groceries.add(0, item);
                    break;
                case "Unnecessary":
                    if (exists(groceries, item))
                        groceries.remove(item);
                    break;
                case "Correct":
                    if (exists(groceries, item)) {
                        String newItem = token[2];
                        for (int i = 0; i < groceries.size(); i++) {
                            if (groceries.get(i).equals(item))
                                groceries.set(i, newItem);
                        }
                    }
                    break;
                case "Rearrange":
                    if (exists(groceries, item)) {
                        groceries.remove(item);
                        groceries.add(item);
                    }
            }

            input = scan.nextLine();
        }

        System.out.println(groceries.toString().replaceAll("[\\[\\]]", ""));
    }
    static boolean exists(List<String> list, String item) {
        for (String s : list) {
            if (s.equals(item))
                return true;
        }
        return false;
    }
}
