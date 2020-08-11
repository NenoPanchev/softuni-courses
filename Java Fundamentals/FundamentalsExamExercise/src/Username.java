import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Sign up")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Case":
                    if (tokens[1].equals("lower")) {
                        username = username.toLowerCase();
                    } else if (tokens[1].equals("upper")) {
                        username = username.toUpperCase();
                    }
                    System.out.println(username);
                    break;
                case "Reverse":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]) + 1;
                    if (start >= 0 && start < username.length() && end >= 0 && end < username.length()){
                        String substring = username.substring(start, end);
                        String reversed = "";
                        for (int i = substring.length() - 1; i >= 0; i--) {
                            reversed += substring.charAt(i);
                        }
                        System.out.println(reversed);
                    }
                    break;
                case "Cut":
                    String substring = tokens[1];
                    if (username.contains(substring)) {
                        username = username.replace(substring, "");
                        System.out.println(username);
                    } else
                        System.out.printf("The word %s doesn't contain %s.%n", username, substring);
                    break;
                case "Replace":
                    username = username.replaceAll(tokens[1], "*");
                    System.out.println(username);
                    break;
                case "Check":
                    if (username.contains(tokens[1]))
                        System.out.println("Valid");
                        else System.out.printf("Your username must contain %s.%n", tokens[1]);
                    break;
            }

            input = scan.nextLine();
        }
    }
}
