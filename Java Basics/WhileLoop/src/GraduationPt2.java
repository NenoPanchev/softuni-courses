import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        int clas = 12;
        double avgGrade = 0;
        int counter = 0;
        int currentClass = 1;

        while (clas > 0 && counter < 2){
            double grade = Double.parseDouble(scan.nextLine());
            if (grade < 4){
                clas++;
                counter++;
            } else {
                avgGrade = avgGrade + grade;
                currentClass++;
            }
            clas--;
        }
        if (counter < 2) {
            System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade / 12);
        }
        else
            System.out.printf("%s has been excluded at %d grade", name, currentClass);
    }
}
