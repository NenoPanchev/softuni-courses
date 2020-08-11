import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        if (!checkIfItsLongEnough(password))
            System.out.println("Password must be between 6 and 10 characters");

        if (!checkIfItHasOnlyLettersAndDigits(password))
            System.out.println("Password must consist only of letters and digits");

        if (!checkTwoDigits(password))
            System.out.println("Password must have at least 2 digits");

        if (checkIfItsLongEnough(password) && checkIfItHasOnlyLettersAndDigits(password) && checkTwoDigits(password))
            System.out.println("Password is valid");
    }
    static boolean checkIfItsLongEnough(String length) {
        if (length.length() > 5 && length.length() < 11)
            return true;
        return false;
    }
    static boolean checkIfItHasOnlyLettersAndDigits(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            if (Character.isDigit(letters.charAt(i)) || Character.isLetter(letters.charAt(i))) {
            } else return false;
        }
        return true;
    }
    static boolean checkTwoDigits(String digits) {
        int counter = 0;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) >= 48 && digits.charAt(i) <= 57 )
                counter++;
        }
        if (counter >= 2) return true;
        return false;
    }
}
