package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        name += " " + scan.next();

        Tuple<String, String> personAddress = new Tuple<>(name, scan.nextLine().trim());
        String[] input = scan.nextLine().split("\\s+");
        Tuple<String, Integer> personAmountBeer = new Tuple<>(input[0], Integer.parseInt(input[1]));
        input = scan.nextLine().split("\\s+");
        Tuple<Integer, Double> intDouble = new Tuple<>(Integer.parseInt(input[0]), Double.parseDouble(input[1]));

        System.out.println(personAddress);
        System.out.println(personAmountBeer);
        System.out.println(intDouble);
    }
}
