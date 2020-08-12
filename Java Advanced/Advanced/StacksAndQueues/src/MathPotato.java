import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] kids = scan.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(kids));
        int num = Integer.parseInt(scan.nextLine());
        int counter = 1;
        int cycle = 1;
        while (queue.size() > 1) {
            if (counter % num == 0) {
                if (cycle > 1 && isPrime(cycle)) {
                    String primeKid = queue.peek();
                    System.out.println("Prime " + queue.poll());
                    queue.offer(primeKid);
                    counter++;
                } else {
                    System.out.println("Removed " + queue.poll());
                }
                cycle++;
            } else {
                String currentKid = queue.poll();
                queue.offer(currentKid);
            }
            counter++;
        }
        System.out.printf("Last is %s", queue.poll());
    }
    static boolean isPrime(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
                if (counter > 2)
                    return false;
            }
        }
        return true;
    }
}
