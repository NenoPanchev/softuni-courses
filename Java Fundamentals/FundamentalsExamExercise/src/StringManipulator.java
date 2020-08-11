import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Done")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Change":
                   text = text.replaceAll(tokens[1], tokens[2]);
                    System.out.println(text);
                    break;
                case "Includes":
                    if (text.contains(tokens[1]))
                        System.out.println("True");
                    else System.out.println("False");
                    break;
                case "End":
                    if (text.endsWith(tokens[1]))
                        System.out.println("True");
                    else System.out.println("False");
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    System.out.println(text.indexOf(tokens[1]));
                    break;
                case "Cut":
                    text = text.substring(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[1]) +
                            Integer.parseInt(tokens[2]));
                    System.out.println(text);
            }

            command = scan.nextLine();
        }
    }
}
