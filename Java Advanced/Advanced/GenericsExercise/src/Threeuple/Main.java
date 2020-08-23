package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];

        Threeuple<String, String, String> personAddressTown = new Threeuple<>(name, address, town);

        input = scan.nextLine().split("\\s+");
        name = input[0];
        int amountOfBeer = Integer.parseInt(input[1]);
        boolean isDrunk = input[2].equals("drunk");
        Threeuple<String, Integer, Boolean> personBeer = new Threeuple<>(name, amountOfBeer, isDrunk);

        input = scan.nextLine().split("\\s+");
        name = input[0];
        double accountBalance = Double.parseDouble(input[1]);
        String bank = input[2];
        Threeuple<String, Double, String> nameAccountBalanceBank = new Threeuple<>(name, accountBalance, bank);

        System.out.println(personAddressTown);
        System.out.println(personBeer);
        System.out.println(nameAccountBalanceBank);
    }
}
