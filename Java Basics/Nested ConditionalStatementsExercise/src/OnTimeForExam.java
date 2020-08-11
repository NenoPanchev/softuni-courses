import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hhExam = Integer.parseInt(scan.nextLine());
        int mmExam = Integer.parseInt(scan.nextLine());
        int hhComing = Integer.parseInt(scan.nextLine());
        int mmComing = Integer.parseInt(scan.nextLine());

        int totalExam = hhExam * 60 + mmExam;
        int totalComing = hhComing * 60 + mmComing;
        int early = totalExam - totalComing;
        int late = totalComing - totalExam;

        if (totalComing > totalExam)
            System.out.println("Late");
        else if ((early <= 30 && (totalExam - totalComing) >= 0))
        System.out.println("On time");
        else if (early > 30)
            System.out.println("Early");

        if (early < 60 && early > 0)
            System.out.printf("%d minutes before the start", early);
        else if (early >= 60){
            if ((early % 60) < 10)
                System.out.printf("%d:0%d hours before the start", (early / 60), (early % 60));
            else System.out.printf("%d:%d hours before the start", (early / 60), (early % 60));
        } else if (late < 60 && late > 0)
            System.out.printf("%d minutes after the start", late);
        else if (late >= 60){
            if ((late % 60) < 10)
                System.out.printf("%d:0%d hours after the start", (late / 60), (late % 60));
            else System.out.printf("%d:%d hours after the start", (late / 60), (late % 60));
        }
    }
}
