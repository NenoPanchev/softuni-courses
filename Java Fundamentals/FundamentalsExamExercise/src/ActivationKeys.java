import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawActivationKey = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains":
                    String substring = tokens[1];
                    if (rawActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rawActivationKey, substring);
                    } else
                        System.out.println("Substring not found!");
                    break;

                case "Flip":
                    String upOrLow = tokens[1];
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String sub = rawActivationKey.substring(startIndex,endIndex);
                    if (upOrLow.equalsIgnoreCase("Upper")) {
                        sub = sub.toUpperCase();
                    } else
                        sub = sub.toLowerCase();
                    String firstPart = rawActivationKey.substring(0, startIndex);
                    String lastPart = rawActivationKey.substring(endIndex);
                    rawActivationKey = firstPart + sub + lastPart;
                    System.out.println(rawActivationKey);
                    break;

                case "Slice":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    String first = rawActivationKey.substring(0, start);
                    String last = rawActivationKey.substring(end);
                    rawActivationKey = first + last;
                    System.out.println(rawActivationKey);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", rawActivationKey);
    }
}
