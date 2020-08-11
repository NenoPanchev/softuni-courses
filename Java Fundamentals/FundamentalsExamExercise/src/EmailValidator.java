import java.util.Arrays;
import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String input = scan.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Make":
                    String letterCase = tokens[1];
                    if (letterCase.equals("Upper"))
                        email = email.toUpperCase();
                    else
                        email = email.toLowerCase();
                    System.out.println(email);
                    break;

                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    String domain = email.substring(email.length() - count);
                    System.out.println(domain);
                    break;

                case "GetUsername":
                    if (email.contains("@")) {
                        String username = email.substring(0, email.indexOf("@"));
                        System.out.println(username);
                    } else
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    break;

                case "Replace":
                    String oldChar = tokens[1];
                    email = email.replaceAll(oldChar, "-");
                    System.out.println(email);
                    break;

                case "Encrypt":
                    int[] asciiNumbers = new int[email.length()];
                    for (int i = 0; i < email.length(); i++) {
                        int asciiNumOfChar = email.charAt(i);
                        asciiNumbers[i] = asciiNumOfChar;
                    }
                    System.out.println(Arrays.toString(asciiNumbers).replaceAll("[\\[\\],]", ""));
                    break;
            }

            input = scan.nextLine();
        }
    }
}
