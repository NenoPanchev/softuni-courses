import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= num; i++){
            for (int cols = 0; cols < i; cols++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
