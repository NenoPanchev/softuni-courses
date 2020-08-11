import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : input) {
            String wordInLowerCase = word.toLowerCase();
            wordCount.putIfAbsent(wordInLowerCase, 0);
            wordCount.put(wordInLowerCase, wordCount.get(wordInLowerCase) + 1);
        }

        List<String> oddCount = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() % 2 != 0)
                oddCount.add(entry.getKey());
        }

        System.out.println(String.join(", ", oddCount));
    }
}
