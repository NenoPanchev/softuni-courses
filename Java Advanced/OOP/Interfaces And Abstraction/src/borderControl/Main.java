package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Identifiable> allIDs = new ArrayList<>();

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[1], tokens[0]);
                allIDs.add(robot);
            } else {
                Citizen citizen = new Citizen(tokens[0],
                        Integer.parseInt(tokens[1]),
                        tokens[2]);
                allIDs.add(citizen);
            }

            input = scan.nextLine();
        }
        String endOfID = scan.nextLine();

        allIDs.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(endOfID))
                .forEach(System.out::println);
    }
}
