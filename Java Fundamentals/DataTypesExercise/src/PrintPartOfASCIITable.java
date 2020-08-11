import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());

        char letter = (char) start;
        char last = (char) end;
        for (char i = letter; i <= last; i++){
            System.out.printf("%c ", i);
        }
    }
}
