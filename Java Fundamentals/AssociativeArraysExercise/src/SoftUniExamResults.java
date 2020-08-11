import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, Integer> studentsResult = new TreeMap<>();
        TreeMap<String, Integer> languageSubmission = new TreeMap<>();

        String input = scan.nextLine();
        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            if (!tokens[1].equals("banned")) {
                String name = tokens[0];
                String language = tokens[1];
                int result = Integer.parseInt(tokens[2]);
                studentsResult.putIfAbsent(name, 0);
                if (result > studentsResult.get(name))
                    studentsResult.put(name, result);

                languageSubmission.putIfAbsent(language, 0);
                languageSubmission.put(language, languageSubmission.get(language) + 1);
            } else {
                studentsResult.remove(tokens[0]);
            }
            input = scan.nextLine();
        }
        System.out.println("Results:");
        studentsResult
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(entry -> System.out.printf("%s | %d%n", entry.getKey(), entry.getValue()));
        System.out.println("Submissions:");
        languageSubmission
                .entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}
