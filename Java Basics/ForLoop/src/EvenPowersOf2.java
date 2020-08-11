import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int n = 1;
        for (int i = 0; i <= num; i+= 2) {
            System.out.println(n);
            n = n * 2 * 2;
        }
    }
}
