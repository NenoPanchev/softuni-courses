import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Delete":
                    numbers.removeIf(n -> n == Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    if (Integer.parseInt(tokens[2]) >= 0 && Integer.parseInt(tokens[2]) < numbers.size())
                    numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
