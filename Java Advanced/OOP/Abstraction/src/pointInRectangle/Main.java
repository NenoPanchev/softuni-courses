package pointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Rectangle rectangle = new Rectangle(createPointFromTwoIntsFrom(scan), createPointFromTwoIntsFrom(scan));
        int pointsToRead = scan.nextInt();

        for (int i = 0; i < pointsToRead; i++) {
            Point point = createPointFromTwoIntsFrom(scan);
            System.out.println(rectangle.contains(point));
        }
    }

    static Point createPointFromTwoIntsFrom(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        Point point = new Point(x, y);
        return point;
    }
}
