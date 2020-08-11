import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double area = 0.0;
        String figure = scan.nextLine();

        if (figure.equals("square")) {
            double sideA = Double.parseDouble(scan.nextLine());
            area = Math.pow(sideA, 2);
        } else if (figure.equals("rectangle")){
            double sideA = Double.parseDouble(scan.nextLine());
            double sideB = Double.parseDouble(scan.nextLine());
            area = sideA * sideB;
        } else if (figure.equals("circle")){
            double r = Double.parseDouble(scan.nextLine());
            area = Math.PI * Math.pow(r, 2);
        } else if (figure.equals("triangle")){
            double side = Double.parseDouble(scan.nextLine());
            double h = Double.parseDouble(scan.nextLine());
            area = side * h / 2;
        }
        System.out.printf("%.3f", area);
    }
}
