import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targetList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            String command = token[0];
            int index = Integer.parseInt(token[1]);
            int value = Integer.parseInt(token[2]);

            switch (command) {
                case "Shoot":
                    if (index >= 0 && index < targetList.size()) {
                        targetList.set(index, targetList.get(index) - value);
                        if (targetList.get(index) <= 0)
                            targetList.remove(index);
                    } break;
                case "Add":
                    if (index >= 0 && index < targetList.size())
                        targetList.add(index, value);
                    else System.out.println("Invalid placement!");
                    break;
                case "Strike":
                    if (targetList.size() >= 2 * value + index && index >= value && index < targetList.size() - value) {
                        int counter = 0;
                        while (counter < 2 * value + 1) {
                            targetList.remove(index - 1);
                            counter++;
                        }
                    } else System.out.println("Strike missed!");

            }

            input = scan.nextLine();
        }
        System.out.printf("%d", targetList.get(0));
        if (targetList.size() > 1) {
            for (int i = 1; i < targetList.size(); i++) {
                System.out.printf("|%d", targetList.get(i));
            }
        }
    }
}
