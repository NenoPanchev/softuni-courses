import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        long[] lastArray = new long[num];

        for (int i = 0; i < num; i++) {
            long[] arr = new long[i + 1];
            arr[0] = 1;
            if (i > 0) arr[i] = 1;

            if (i > 1) {
                for (int j = 0; j <= i - 2; j++) {
                    arr[j + 1] = lastArray[j] + lastArray[j + 1];
                }
            }
            lastArray = arr;
            for (long print : arr) {
                System.out.printf("%d ", print);
            }
            System.out.println();
        }
    }
}
