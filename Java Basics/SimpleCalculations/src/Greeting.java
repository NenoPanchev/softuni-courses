import java.util.Scanner;

public class Greeting {
    public static void main(String[]args) {
        Scanner scann = new Scanner (System.in);
        String name = scann.nextLine();
        System.out.printf("Hello, %s!", name);
    }
}
