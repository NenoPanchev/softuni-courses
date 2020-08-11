import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(",\\s+");
        Map<String, Integer> pplsResult = new LinkedHashMap<>();
        for (String name : names) {
            pplsResult.putIfAbsent(name, 0);
        }
        Pattern letters = Pattern.compile("[A-Za-z]");
        Pattern digits = Pattern.compile("\\d");
        String input = scan.nextLine();
        while (!input.equals("end of race")) {
            Matcher lettersMatcher = letters.matcher(input);
            Matcher digitsMatcher = digits.matcher(input);
            StringBuilder name = new StringBuilder();
            while (lettersMatcher.find()) {
                name.append(lettersMatcher.group());
            }
            for (String s : names) {
                if (name.toString().equals(s)) {
                    int sum = 0;
                    while (digitsMatcher.find()) {
                        sum += Integer.parseInt(digitsMatcher.group());
                    }
                    pplsResult.put(s, pplsResult.get(s) + sum);
                }
            }

            input = scan.nextLine();
        }
        List<String> winners = new ArrayList<>(3);
        pplsResult.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(3)
                .forEach(s -> winners.add(s.getKey()));

        System.out.printf("1st place: %s%n", winners.get(0));
        System.out.printf("2nd place: %s%n", winners.get(1));
        System.out.printf("3rd place: %s%n", winners.get(2));

    }
}
