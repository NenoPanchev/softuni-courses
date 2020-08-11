import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int doctors = 7;
        int treated = 0;
        int notTreated = 0;

        for (int i = 1; i <= days; i++) {
            int num = Integer.parseInt(scan.nextLine());
            if (i % 3 == 0) {
                if (notTreated > treated) {
                    doctors++;
                }
            }
            if (num <= doctors) {
                treated += num;
            } else {
                treated += doctors;
                notTreated += (num - doctors);
            }
        }
        System.out.printf("Treated patients: %d.%n", treated);
        System.out.printf("Untreated patients: %d.", notTreated);
    }

}
