import java.util.Scanner;

public class WeddingHall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double lengthHall = Double.parseDouble(scan.nextLine());
        double widthHall = Double.parseDouble(scan.nextLine());
        double barSide = Double.parseDouble(scan.nextLine());

        double hallArea = lengthHall * widthHall;
        double barArea = barSide * barSide;
        double dancingArea = hallArea * 19 / 100;
        double freeSpace = hallArea - barArea - dancingArea;
        double people = Math.ceil(freeSpace / 3.2);

        System.out.printf("%.0f", people);
    }
}
