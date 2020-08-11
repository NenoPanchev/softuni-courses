import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("For Azeroth")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "GladiatorStance":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;

                case "DefensiveStance":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;

                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < text.length()) {
                        char ch = tokens[2].charAt(0);
                        StringBuilder newText = new StringBuilder(text);
                        newText.setCharAt(index, ch);
                        text = newText.toString();
                        System.out.println("Success!");
                    } else
                        System.out.println("Dispel too weak.");
                    break;

                case "Target":
                    String action = tokens[1];
                    String substring = tokens[2];
                    switch (action) {
                        case "Change":
                            String secondSubstring = tokens[3];
                            text = text.replace(substring, secondSubstring);
                            System.out.println(text);
                            break;

                        case "Remove":
                            if (text.contains(substring)) {
                                text = text.replaceFirst(substring, "");
                                System.out.println(text);
                            }
                            break;

                        default:
                            System.out.println("Command doesn't exist!");
                            break;
                    }
                    break;

                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }

            input = scan.nextLine();
        }
    }
}
