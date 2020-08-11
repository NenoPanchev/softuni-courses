import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("Craft!")){
            String[] token = input.split("\\s+-\\s+");
            String command = token[0];
            String item = token[1];

            switch (command) {
                case "Collect":
                    if (!exists(list, item))
                        list.add(item);
                    break;

                case "Drop":
                    if (exists(list, item))
                        list.remove(item);
                    break;

                case "Combine Items":
                    String[] items = item.split(":");
                    String oldItem = items[0];
                    if (exists(list, oldItem)) {
                        String newItem = items[1];
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(oldItem)) {
                                list.add(i + 1, newItem);
                                break;
                            }
                        }
                    }
                    break;

                case "Renew":
                    if (exists(list, item)) {
                        list.remove(item);
                        list.add(item);
                }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
    }
    static boolean exists(List<String> list, String item) {
        for (String s : list) {
            if (s.equals(item))
                return true;
        }
        return false;
    }
}
