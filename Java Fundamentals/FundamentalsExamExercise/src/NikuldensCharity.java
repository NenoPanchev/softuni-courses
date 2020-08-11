import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String input = scan.nextLine();

        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Replace":
                    String oldChar = tokens[1];
                    String newChar = tokens[2];
                    message = message.replaceAll(oldChar, newChar);
                    System.out.println(message);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (checkIndexes(startIndex, endIndex, message)) {
                        message = message.substring(0, startIndex) + message.substring(endIndex + 1);
                        System.out.println(message);
                    } else
                        System.out.println("Invalid indexes!");
                    break;

                case "Make":
                    String letterCase = tokens[1];
                    if (letterCase.equals("Upper")) {
                        message = message.toUpperCase();
                    } else if (letterCase.equals("Lower"))
                        message = message.toLowerCase();
                    System.out.println(message);
                    break;

                case "Check":
                    String containingString = tokens[1];
                    if (message.contains(containingString))
                        System.out.println("Message contains " + containingString);
                    else
                        System.out.println("Message doesn't contain " + containingString);
                    break;

                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    if (checkIndexes(startIndex, endIndex, message)) {
                        int sum = 0;
                        String sub = message.substring(startIndex, endIndex + 1);
                        for (int i = 0; i < sub.length(); i++) {
                            sum += sub.charAt(i);
                        }
                        System.out.println(sum);
                    } else
                        System.out.println("Invalid indexes!");
                    break;
            }

            input = scan.nextLine();
        }
    }
    static boolean checkIndexes(int startIndex, int endIndex, String message){
        return startIndex >= 0 && startIndex < message.length() && endIndex >= 0 && endIndex < message.length();
    }
}
