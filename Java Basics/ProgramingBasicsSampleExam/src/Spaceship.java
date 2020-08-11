import java.util.Scanner;

public class Spaceship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double averageHeight = Double.parseDouble(scan.nextLine());

        double volume = width * length * height;
        double people = Math.floor(volume / (2 * 2 * (averageHeight + 0.40)));

        if (people < 3)
            System.out.println("The spacecraft is too small.");
        else if (people < 10)
            System.out.printf("The spacecraft holds %.0f astronauts.", people);
        else
            System.out.println("The spacecraft is too big.");
    }
}
