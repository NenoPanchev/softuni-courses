import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(Integer.parseInt(tokens[1])));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
                    break;
            }
            command = scan.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
