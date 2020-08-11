import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String text = scan.nextLine();
            int key = 0;
            Pattern keyPattern = Pattern.compile("[SsTtAaRr]");
            Matcher keyMatcher = keyPattern.matcher(text);
            while (keyMatcher.find()) {
                key++;
            }
            String cipheredText = cipher(text, key);
            Pattern cipherPattern = Pattern.compile("@(?<planet>[A-Z]+[a-z]+)[^@:>.!-]*?:(?<population>\\d+)[^@:>.!-]*?!(?<attackType>[AD])![^@:>.!-]*?->(?<soldiersCount>\\d+)");
            Matcher cipherMatcher = cipherPattern.matcher(cipheredText);

            if (cipherMatcher.find()) {
                String planet = cipherMatcher.group("planet");
                int population = Integer.parseInt(cipherMatcher.group("population"));
                String attackType = cipherMatcher.group("attackType");
                int soldiersCount = Integer.parseInt(cipherMatcher.group("soldiersCount"));
                if (attackType.equals("A"))
                    attackedPlanets.add(planet);
                else if (attackType.equals("D"))
                    destroyedPlanets.add(planet);
            }
        }
            System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
            attackedPlanets
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .forEach(s -> System.out.printf("-> %s%n", s));
            System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
            destroyedPlanets
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .forEach(s -> System.out.printf("-> %s%n", s));
    }
    static String cipher(String word, int key) {
        char[] wordCharacters = word.toCharArray();
        for (int i = 0; i < wordCharacters.length; i++) {
            wordCharacters[i] -= key;
        }

        return new String(wordCharacters);
    }
}
