import javax.swing.*;
import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        if (number >= 100 && number <= 200 || number == 0){

        } else
            System.out.println("invalid");

    }
}
