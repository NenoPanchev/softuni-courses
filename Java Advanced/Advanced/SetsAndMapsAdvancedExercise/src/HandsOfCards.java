import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> personsHand = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"JOKER".equals(input)) {
            String[] split = input.split(":\\s+");
            String name = split[0];
            String[] tokens  = split[1].split(",\\s+");
            personsHand.putIfAbsent(name, new HashSet<>());
            for (String token : tokens) {
                personsHand.get(name).add(token);
            }
            input = scan.nextLine();
        }
        personsHand.entrySet()
                .forEach(x -> {
                    System.out.printf("%s: ", x.getKey());
                    Pattern pattern = Pattern.compile("(?<value>(\\d+|[A-Z]))(?<type>[A-Z])");
                    int sum = 0;
                    for (String s : x.getValue()) {
                        sum += getValue(pattern, s);
                    }
                    System.out.println(sum);
                });
    }

    private static int getValue(Pattern pattern, String card) {
        int value = 0;
        int type = 0;
        Matcher matcher = pattern.matcher(card);
        matcher.find();
        String cardPower = matcher.group(1);
        try {
            value = Integer.parseInt(cardPower);
        } catch (Exception e) {
            switch (cardPower) {
                case "J":
                    value = 11;
                    break;
                case "Q":
                    value = 12;
                    break;
                case "K":
                    value = 13;
                    break;
                case "A":
                    value = 14;
                    break;
            }
        }
            String cardType = matcher.group("type");
            switch (cardType) {
                case "S":
                    type = 4;
                    break;
                case "H":
                    type = 3;
                    break;
                case "D":
                    type = 2;
                    break;
                case "C":
                    type = 1;
                    break;
            }

        return value * type;
    }
}
