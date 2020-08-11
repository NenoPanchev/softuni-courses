import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double side = Double.parseDouble(scan.nextLine());
        double tileWidth = Double.parseDouble(scan.nextLine());
        double tileLength = Double.parseDouble(scan.nextLine());
        double benchWidth = Double.parseDouble(scan.nextLine());
        double benchLength = Double.parseDouble(scan.nextLine());
        double area = side * side;
        double benchArea = benchLength * benchWidth;
        double tiles = (area - benchArea) / (tileLength * tileWidth);
        double time = tiles * 0.2;
        System.out.println(tiles);
        System.out.println(time);
    }
}
