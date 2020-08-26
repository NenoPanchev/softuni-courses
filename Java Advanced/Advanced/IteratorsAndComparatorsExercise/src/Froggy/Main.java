package Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lake list = new Lake(Arrays.stream(scan.nextLine().split(", "))
        .mapToInt(Integer::parseInt).toArray());

        String input = scan.nextLine();
        if (input.equals("END")) {
            System.out.println(list);
        }
    }
}
