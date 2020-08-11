import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int lectures = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());

        double totalBonus = 0;
        double maxBonus = 0;
        int attentance = 0;

        for (int i = 0; i < students; i++) {
            int currentStudentAttendance = Integer.parseInt(scan.nextLine());
            totalBonus = Math.ceil(1.0 * currentStudentAttendance / lectures * (5 + bonus));
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                attentance = currentStudentAttendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.%n", attentance);
    }
}
