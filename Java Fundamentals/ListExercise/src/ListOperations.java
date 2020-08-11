import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;

                case "Insert":
                    if (Integer.parseInt(tokens[2]) >= 0 && Integer.parseInt(tokens[2]) < numbers.size())
                        numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                    else System.out.println("Invalid index");
                    break;

                case "Remove":
                    if (Integer.parseInt(tokens[1]) >= 0 && Integer.parseInt(tokens[1]) < numbers.size())
                    numbers.remove(Integer.parseInt(tokens[1]));
                    else System.out.println("Invalid index");
                    break;

                case "Shift":
                    shiftPositionsLeftOrRight(numbers, tokens[1], Integer.parseInt(tokens[2]));

            }
            command = scan.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
    static void shiftPositionsLeftOrRight(List<Integer> num, String side, int positions) {
        if (side.equals("left")) {
            for (int i = 0; i < positions; i++) {
                num.add(num.get(0));
                num.remove(0);
            }
        } else if (side.equals("right")) {
            for (int i = 0; i < positions; i++) {
                num.add(0, num.get(num.size() - 1));
                num.remove(num.size() - 1);
            }
        }
    }
}
