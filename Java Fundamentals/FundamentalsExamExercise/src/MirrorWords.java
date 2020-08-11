import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        LinkedHashMap<String, String> list = new LinkedHashMap<>();
        int validPairsCounter = 0;

            while (matcher.find()) {
                String firstWord = matcher.group("firstWord");
                String secondWord = matcher.group("secondWord");
                validPairsCounter++;
                StringBuilder reversed = new StringBuilder();
                for (int i = secondWord.length() - 1; i >= 0; i--) {
                    reversed.append(secondWord.charAt(i));
                }
                if (firstWord.equals(reversed.toString())) {
                    list.put(firstWord, secondWord);
                }
            }

        if (validPairsCounter > 0)
            System.out.printf("%d word pairs found!%n", validPairsCounter);
        else
            System.out.println("No word pairs found!");

        if (list.size() != 0) {
            List<String> pairs = new LinkedList<>();
            System.out.println("The mirror words are:");
            list.entrySet().forEach(x -> {
                pairs.add(x.getKey() + " <=> " + x.getValue());
            });
            System.out.println(String.join(", ", pairs));
        } else
            System.out.println("No mirror words!");
    }
}
