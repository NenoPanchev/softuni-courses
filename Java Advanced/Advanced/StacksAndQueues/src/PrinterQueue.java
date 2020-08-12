import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> filesToPrint = new ArrayDeque<>();
        while (!"print".equals(input)) {
            if ("cancel".equals(input)) {
                if (filesToPrint.isEmpty())
                    System.out.println("Printer is on standby");
                else
                    System.out.printf("Canceled %s%n", filesToPrint.poll());
            } else {
                filesToPrint.offer(input);
            }
            input = scan.nextLine();
        }
        for (String s : filesToPrint) {
            System.out.println(s);
        }
    }
}
