import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int failGrades = Integer.parseInt(scan.nextLine());
        String lastProblem = "";
        int problemsCount = 0;
        int sumGrade = 0;
        int failCount = 0;

        while (failCount < failGrades){
           String problemName = scan.nextLine();
            if (problemName.equals("Enough")){break;}

            int grade = Integer.parseInt(scan.nextLine());
            if (grade <= 4){
                failCount++;
                if (failCount >= failGrades){break;}
            }
            problemsCount++;
            sumGrade += grade;
            lastProblem = problemName;

        }
        if (failCount >= failGrades)
            System.out.printf("You need a break, %d poor grades.", failGrades);
        else {
            System.out.printf("Average score: %.2f", sumGrade * 1.0 / problemsCount);
            System.out.println();
            System.out.printf("Number of problems: %d", problemsCount);
            System.out.println();
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
