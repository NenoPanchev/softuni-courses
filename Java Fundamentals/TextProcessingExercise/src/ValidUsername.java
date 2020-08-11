import java.util.Scanner;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] userNames = scan.nextLine().split(", ");

        for (String name : userNames) {
            if (isValid(name))
                System.out.println(name);
        }


    }
    public static boolean isValid(String name) {
        if (name.length() >= 3 && name.length() <= 16) {
            for (int i = 0; i < name.length(); i++) {
                if (!Character.isLetterOrDigit(name.charAt(i))
                        && name.charAt(i) != '-' && name.charAt(i) != '_') {
                    return false;

                }
            }
        } else return false;
        return true;
    }
}
