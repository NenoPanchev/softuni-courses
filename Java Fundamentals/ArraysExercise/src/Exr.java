import java.util.Scanner;

public class Exr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int rows = 1; rows <= num; rows++) {
            for (int cols = 1; cols <= rows ; cols++) {
                System.out.print("1 ");
            }
            System.out.println();
        }
    }
}
