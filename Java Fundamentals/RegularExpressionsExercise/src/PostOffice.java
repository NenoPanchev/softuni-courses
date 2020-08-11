import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] texts = scan.nextLine().split("\\|");
        Pattern capitalLetters = Pattern.compile("([#$%*&])(?<capital>[A-Z]+)\\1");
        Matcher matchCapital = capitalLetters.matcher(texts[0]);
        Pattern codes = Pattern.compile("(?<letterCode>\\d{2}):(?<numberOfLetters>\\d{2})");
        Matcher matchCodes = codes.matcher(texts[1]);
        Pattern possibleWords = Pattern.compile("(^|(?<=\\s))[A-Z][^ ]+");
        Matcher matchWords = possibleWords.matcher(texts[2]);
        List<Character> capital = new ArrayList<>();
        if (matchCapital.find()) {
            for (int i = 0; i < matchCapital.group("capital").length(); i++) {
                capital.add(matchCapital.group("capital").charAt(i));
            }
        }
        LinkedHashMap<Integer, Integer> letterCodes = new LinkedHashMap<>();
        while (matchCodes.find()) {
            int capitalCode = Integer.parseInt(matchCodes.group("letterCode"));
            int letterNumbers = Integer.parseInt(matchCodes.group("numberOfLetters"));
            letterCodes.put(capitalCode, letterNumbers);
        }
        List<String> words = new ArrayList<>();
        while (matchWords.find())
            words.add(matchWords.group());

        for (Character character : capital) {
            int charNum = character;
            for (Map.Entry<Integer, Integer> entry : letterCodes.entrySet()) {
                if (charNum == entry.getKey()) {
                    for (String word : words) {
                        if (word.charAt(0) == character && word.length() == entry.getValue() + 1)
                            System.out.println(word);
                    }
                }
            }
        }
    }
}
