import java.util.*;
import java.util.stream.Collectors;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> cards = Arrays.stream(scan.nextLine().split(":"))
                .collect(Collectors.toList());
        List<String> deck = new LinkedList<>();
        String input = scan.nextLine();
        while (!"Ready".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String cardName = tokens[1];

            switch (command) {
                case "Add":
                    if (!cards.contains(cardName)) {
                        System.out.println("Card not found.");
                    } else {
                        deck.add(cardName);
                    }
                    break;

                case "Remove":
                    if (deck.contains(cardName)) {
                        deck.remove(cardName);
                    } else
                        System.out.println("Card not found.");
                    break;

                case "Swap":
                    String secondCard = tokens[2];
                    int firstIndex = 0;
                    int secondIndex = 0;
                    for (int i = 0; i < deck.size(); i++) {
                        if (deck.get(i).equals(cardName))
                            firstIndex = i;
                        else if (deck.get(i).equals(secondCard))
                            secondIndex = i;
                    }
                    deck.set(firstIndex, secondCard);
                    deck.set(secondIndex, cardName);
                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < deck.size() && cards.contains(cardName)) {
                            deck.add(index, cardName);
                    } else
                        System.out.println("Error!");
                    break;

                case "Shuffle":
                    Collections.reverse(deck);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(" ", deck));
    }
}
