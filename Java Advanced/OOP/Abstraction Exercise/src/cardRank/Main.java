package cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(input + ":");
        for (CardRank cardSuit : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.value, cardSuit);
        }
    }
}
