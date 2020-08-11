import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";
        int counter = 0;
        for (int i = username.length() - 1; i > -1; i--){
            char letter = username.charAt(i);
            password += letter;
        }
        String newPassword = scan.nextLine();
        while (!newPassword.equals(password)){
            counter++;
            if (counter == 4) break;
            System.out.println("Incorrect password. Try again.");
         newPassword = scan.nextLine();
        }
        if (counter < 4) System.out.printf("User %s logged in.", username);
        else System.out.printf("User %s blocked!", username);
    }
}
