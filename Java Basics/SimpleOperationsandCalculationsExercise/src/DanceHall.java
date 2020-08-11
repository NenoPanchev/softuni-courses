import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double side = Double.parseDouble(scan.nextLine());
        double area = length * width;
        double wardrobeArea = side * side;
        double benchArea = area / 10;
        double freeArea = (area - wardrobeArea - benchArea) * 10000;
        double people = (freeArea / (40 + 7000));
        System.out.printf("%.0f", Math.floor(people));
    }
}
