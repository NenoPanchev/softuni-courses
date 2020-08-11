import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split("\\s"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maximumPeoplePerWagon = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            if (tokens[0].equals("Add")) {
                wagons.add(Integer.parseInt(tokens[1]));
            } else {
                int ppl = Integer.parseInt(tokens[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + ppl <= maximumPeoplePerWagon) {
                        wagons.set(i, (wagons.get(i) + ppl));
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
