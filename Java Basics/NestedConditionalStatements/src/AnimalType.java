import java.util.Scanner;

public class AnimalType {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        switch (name) {
            case "dog":
                System.out.println("mammal"); break;
            case "snake":
            case "tortoise":
            case "crocodile":
                System.out.println("reptile"); break;
            default:
                System.out.println("unknown"); break;
        }
    }
}
