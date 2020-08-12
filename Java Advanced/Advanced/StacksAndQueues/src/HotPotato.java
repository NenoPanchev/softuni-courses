import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] kids = scan.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(kids));
        int num = Integer.parseInt(scan.nextLine());
        int counter = 1;
        while (queue.size() > 1) {
            if (counter % num == 0) {
                System.out.println("Removed " + queue.poll());
            } else {
                String currentKid = queue.poll();
                queue.offer(currentKid);
            }
            counter++;
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
