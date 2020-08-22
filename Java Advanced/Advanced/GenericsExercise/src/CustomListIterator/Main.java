package CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    list.add(tokens[1]);
                    break;

                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;

                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;

                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;

                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;

                case "Max":
                    System.out.println(list.getMax());
                    break;

                case "Min":
                    System.out.println(list.getMin());
                    break;

                case "Print":
                    list.print();
                    break;

                case "Sort":
                    list.sort();
                    break;
            }

            input = scan.nextLine();
        }
    }
}
