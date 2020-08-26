package Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListyIterator list = new ListyIterator(Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1).toArray(String[]::new));

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            switch (input) {
                case "Move":
                    System.out.println(list.move());
                    break;

                case "Print":
                    list.print();
                    break;

                case "HasNext":
                    System.out.println(list.hasNext());
                    break;

                case "PrintAll":
                    list.printAll();
                    break;
            }

            input = scan.nextLine();
        }
    }
}
