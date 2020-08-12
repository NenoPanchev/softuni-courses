import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i : input) {
            firstPlayerDeck.add(i);
        }
        input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i : input) {
            secondPlayerDeck.add(i);
        }
        for (int i = 0; i < 50; i++) {
            if (firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty())
                break;
            int firstPlayerTopCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerTopCard);

            int secondPlayerTopCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerTopCard);

            if (firstPlayerTopCard > secondPlayerTopCard) {
                firstPlayerDeck.add(firstPlayerTopCard);
                firstPlayerDeck.add(secondPlayerTopCard);
            } else if (secondPlayerTopCard > firstPlayerTopCard) {
                    secondPlayerDeck.add(firstPlayerTopCard);
                    secondPlayerDeck.add(secondPlayerTopCard);
            }
        }
        if (firstPlayerDeck.size() == secondPlayerDeck.size())
            System.out.println("Draw!");
        else if (firstPlayerDeck.size() < secondPlayerDeck.size())
            System.out.println("Second player win!");
        else
            System.out.println("First player win!");
    }
}
