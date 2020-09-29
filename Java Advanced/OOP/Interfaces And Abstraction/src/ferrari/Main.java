package ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String driver = scan.nextLine();
    Car ferrari = new Ferrari(driver);
        System.out.println(ferrari);
    }
}
