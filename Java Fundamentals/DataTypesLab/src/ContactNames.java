import java.util.Scanner;

public class ContactNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.nextLine();
        String secondName = scan.nextLine();
        String name = scan.nextLine();

        System.out.println(firstName + name + secondName);
    }
}
