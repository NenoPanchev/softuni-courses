import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[] initialField = new int[num];

        int[] bugsAtStart = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < bugsAtStart.length; i++) {
            if (bugsAtStart[i] >= 0 && bugsAtStart[i] < initialField.length) {
                initialField[bugsAtStart[i]] = 1;
            }
        }

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] parts = command.split(" ");
            int bugPosition = Integer.parseInt(parts[0]);
            String direction = parts[1];
            int bugMoveLength = Integer.parseInt(parts[2]);

            if (bugPosition >= 0 && bugPosition < initialField.length && initialField[bugPosition] == 1) {
                initialField[bugPosition] = 0;
                if (direction.equals("right")) {
                    bugPosition += bugMoveLength;
                    while (bugPosition >= 0 && bugPosition < initialField.length && initialField[bugPosition] == 1) {
                        bugPosition += bugMoveLength;
                    }
                    if (bugPosition >= 0 && bugPosition < initialField.length) initialField[bugPosition] = 1;
                } else if (direction.equals("left")) {
                    bugPosition -= bugMoveLength;
                    while (bugPosition >= 0 && bugPosition < initialField.length && initialField[bugPosition] == 1) {
                        bugPosition -= bugMoveLength;
                    }
                    if (bugPosition >= 0 && bugPosition < initialField.length) initialField[bugPosition] = 1;
                }
            }
            command = scan.nextLine();
        }
        for (int value : initialField) {
            System.out.printf("%d ", value);
        }
    }
}

