import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double counter2 = 0;
        double counter3 = 0;
        double counter4 = 0;

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(scan.nextLine());
            if (num % 2 == 0) counter2++;
            if (num % 3 == 0) counter3++;
            if (num % 4 == 0) counter4++;
        }
        System.out.printf("%.2f%%%n", (counter2 / n * 100));
        System.out.printf("%.2f%%%n", (counter3 / n * 100));
        System.out.printf("%.2f%%", (counter4 / n * 100));
    }
}
