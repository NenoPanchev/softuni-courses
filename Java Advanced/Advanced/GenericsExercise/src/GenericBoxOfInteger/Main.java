package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            Box<Integer> input = new Box<>(Integer.parseInt(scan.nextLine()));
            System.out.println(input);
        }
    }
}
