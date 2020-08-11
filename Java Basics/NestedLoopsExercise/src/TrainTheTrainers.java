import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String name = scan.nextLine();
        double totalGrade = 0;
        double counter = 0;

        while (!name.equals("Finish")){
            double currentGrade = 0;
            for (int i = 1; i <= num; i++){
                double grade = Double.parseDouble(scan.nextLine());
                currentGrade+= grade;
            }
            totalGrade += (currentGrade / num);
            System.out.printf("%s - %.2f.%n", name, currentGrade / num);
            currentGrade = 0;
            counter++;
            name = scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalGrade / counter);
    }
}
