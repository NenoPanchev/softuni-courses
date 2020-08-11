import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());

        switch (command) {
            case "add": add(a,b); break;
            case "subtract": subtract(a, b); break;
            case "multiply": multiply(a, b); break;
            case "divide": divide(a,b); break;
        }
    }
    static void add(int a, int b) {
        System.out.println(a + b);
    }
    static void subtract(int a, int b) {
        System.out.println(a - b);
    }
    static void multiply(int a, int b)  {
        System.out.println(a * b);
    }
    static void divide(int a, int b) {
        System.out.println(a / b);
    }
}
