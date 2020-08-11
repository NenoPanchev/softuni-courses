import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, List<String>> wordSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
/*          wordSynonyms.putIfAbsent(word, new ArrayList<>());
            wordSynonyms.get(word).add(synonym);*/
            List<String> currentSynonyms = wordSynonyms.get(word);
            if (currentSynonyms == null) {
                currentSynonyms = new ArrayList<>();
                wordSynonyms.put(word, currentSynonyms);
            }
            currentSynonyms.add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
