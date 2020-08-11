import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                result.append(word);
            }
        }
        System.out.println(result);
    }
}
