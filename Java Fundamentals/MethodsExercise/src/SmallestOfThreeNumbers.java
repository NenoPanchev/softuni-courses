import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        printTheSmallestNumber(a,b,c);
    }
    static void printTheSmallestNumber(int a, int b, int c) {
        int small;
        small = Math.min(a,b);
        System.out.println(Math.min(small, c));
    }
}
