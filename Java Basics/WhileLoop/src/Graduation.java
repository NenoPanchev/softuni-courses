import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        int clas = 12;
        double avgGrade = 0;

        while (clas > 0){
            double grade = Double.parseDouble(scan.nextLine());
            if (grade < 4){
                clas++;
            } else {
                avgGrade = avgGrade + grade;
            }
            clas--;
        }
        System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade / 12);
    }
}
