package LingedListTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        MyList<Integer> list = new MyList<>();
        List<Integer> link = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            Integer number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add":
                    list.add(number);
                    break;

                case "Remove":

                    break;
            }
        }
        System.out.println();
    }
}
