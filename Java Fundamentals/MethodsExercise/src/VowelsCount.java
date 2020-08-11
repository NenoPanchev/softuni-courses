import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        printVowelsCount(name);
    }
    static void printVowelsCount(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'A':
                case 'E':
                case 'O':
                case 'U':
                case 'I':
                case 'a':
                case 'e':
                case 'o':
                case 'u':
                case 'i':
                    counter++; break;
            }
        }
        System.out.println(counter);
    }
}
