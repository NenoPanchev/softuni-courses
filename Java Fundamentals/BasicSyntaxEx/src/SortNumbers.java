import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int n3 = Integer.parseInt(scan.nextLine());

        if (n1 <= n2 && n2 <= n3) {
            System.out.printf("%d\n%d\n%d", n3, n2, n1);
        } else if (n2 <= n3 && n3 <= n1) {
            System.out.printf("%d\n%d\n%d", n1, n3, n2);
        } else if (n3 <= n1 && n1 <= n2) {
            System.out.printf("%d\n%d\n%d", n2, n1, n3);
        } else if (n1 <= n3 && n3 <= n2) {
            System.out.printf("%d\n%d\n%d", n2, n3, n1);
        } else if (n2 <= n1 && n1 <= n3) {
            System.out.printf("%d\n%d\n%d", n3, n1, n2);
        } else if (n3 <= n2 && n2 <= n1) {
            System.out.printf("%d\n%d\n%d", n1, n2, n3);
        }

    }
}
