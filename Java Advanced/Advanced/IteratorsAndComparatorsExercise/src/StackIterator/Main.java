package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack(Arrays.stream(scan.nextLine().split("[, ]+"))
        .skip(1)
        .map(Integer::parseInt).toArray(Integer[]::new));

        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Pop":
                    if (stack.iterator().hasNext()) {
                        stack.pop();
                    } else {
                        System.out.println("No elements");
                    }
                    break;

                case "Push":
                    Integer numberToPush = Integer.parseInt(tokens[1]);
                    stack.push(numberToPush);
                    break;
            }

            input = scan.nextLine();
        }
        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
