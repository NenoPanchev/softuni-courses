import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num; i++){
            char letter = scan.nextLine().charAt(0);
            letter = (char) (letter + key);
            System.out.printf("%c", letter);
        }
    }
}
