import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String concealedMessage = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Reveal")) {
            String[] token = input.split(":\\|:");
            String command = token[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(token[1]);
                    if (index >= 0 && index < concealedMessage.length()) {
                        StringBuilder afterInsertion = new StringBuilder();
                        afterInsertion.append(concealedMessage.substring(0, index));
                        afterInsertion.append(" ");
                        afterInsertion.append(concealedMessage.substring(index));
                        concealedMessage = new String(afterInsertion);
                    }
                    break;

                case "Reverse":
                    String substring = token[1];
                    if (concealedMessage.contains(substring)) {
                       concealedMessage = concealedMessage.replaceFirst(substring, "");
                        StringBuilder reversed = new StringBuilder();
                        for (int i = substring.length() - 1; i >= 0 ; i--) {
                            reversed.append(substring.charAt(i));
                        }
                       concealedMessage += new String(reversed);
                    } else
                        System.out.println("error");
                    break;

                case "ChangeAll":
                    String sub = token[1];
                    String replacement = token[2];
                    while (concealedMessage.contains(sub)) {
                        concealedMessage = concealedMessage.replace(sub, replacement);
                    }
                break;
            }
            System.out.println(concealedMessage);
            input = scan.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", concealedMessage);
    }
}
