import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int toPush = Integer.parseInt(String.valueOf(scan.nextInt()));
        int toPop = Integer.parseInt(String.valueOf(scan.nextInt()));
        int toCheck = Integer.parseInt(String.valueOf(scan.nextInt()));
        ArrayDeque<Integer> numbers = new ArrayDeque<>(toPush);
        for (int i = 0; i < toPush; i++) {
            int num = Integer.parseInt(String.valueOf(scan.nextInt()));
            numbers.push(num);
        }
        for (int i = 0; i < toPop; i++) {
            numbers.pop();
        }
        if (!numbers.isEmpty()) {
            if (numbers.contains(toCheck)) {
                System.out.println("true");
            } else
                System.out.println(Collections.min(numbers));
        } else
            System.out.println("0");
    }
}
