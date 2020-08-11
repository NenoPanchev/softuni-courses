import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TanksCollector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split(",\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String name = tokens[1];
                    if (list.contains(name)) {
                        System.out.println("Tank is already bought");
                    } else {
                        System.out.println("Tank successfully bought");
                        list.add(name);
                    }
                    break;

                case "Remove":
                    name = tokens[1];
                    if (list.contains(name)) {
                        System.out.println("Tank successfully sold");
                        list.remove(name);
                    } else
                        System.out.println("Tank not found");
                    break;

                case "Remove At":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < list.size()) {
                        System.out.println("Tank successfully sold");
                        list.remove(index);
                    } else
                        System.out.println("Index out of range");
                    break;

                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    name = tokens[2];
                    if (index >= 0 && index < list.size()) {
                        if (list.contains(name)) {
                            System.out.println("Tank is already bought");
                        } else {
                            System.out.println("Tank successfully bought");
                            list.add(index, name);
                        }
                    } else
                        System.out.println("Index out of range");
            }
        }
        System.out.println(String.join(", ", list));
    }
}
