import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int num = Integer.parseInt(scan.nextLine());
            System.out.println(getSquaredNumber(num));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Good bye");
        }
    }
    public static double getSquaredNumber(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Invalid number");
        }
            return Math.sqrt(num);

    }
}
