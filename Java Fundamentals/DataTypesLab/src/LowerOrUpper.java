import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            char letter = scan.nextLine().charAt(0);
        if (letter >= 'a' && letter <= 'z') System.out.println("lower-case");
        if (letter >= 'A' && letter <= 'Z') System.out.println("upper-case");

    }
}
