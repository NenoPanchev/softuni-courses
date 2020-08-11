import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();

        while (!input.equals("Done")) {
            String[] token = input.split(" ");
            String command = token[0];

            switch (command){
                case "TakeOdd":
                    StringBuilder odd = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        if (i % 2 != 0)
                            odd.append(text.charAt(i));
                    }
                    text = odd.toString();
                    System.out.println(text);
                    break;

                case "Cut":
                    int index = Integer.parseInt(token[1]);
                    int length = Integer.parseInt(token[2]);
                    String sub = text.substring(index, index + length);
                    text = text.replaceFirst(sub, "");
                    System.out.println(text);
                    break;

                case "Substitute":
                    String substring = token[1];
                    String substitute = token[2];
                    if (text.contains(substring)) {
                        text = text.replace(substring, substitute);
                        System.out.println(text);
                    } else
                        System.out.println("Nothing to replace!");
            }

            input = scan.nextLine();
        }
        System.out.printf("Your password is: %s", text);
    }
}
