import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();

        while (!input.equals("find")) {
            StringBuilder deciphered = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int key = numbers[i % numbers.length];
                char newChar = (char) (currentChar - key);

                deciphered.append(newChar);
            }
            int startTreasure = deciphered.indexOf("&") +1;
            int endTreasure = deciphered.lastIndexOf("&");
            int startCoordinates = deciphered.indexOf("<") + 1;
            int endCoordinates = deciphered.lastIndexOf(">");
            String treasure = deciphered.substring(startTreasure, endTreasure);
            String coordinates = deciphered.substring(startCoordinates, endCoordinates);
            System.out.printf("Found %s at %s%n", treasure, coordinates);

            input = scan.nextLine();
        }
    }
}
