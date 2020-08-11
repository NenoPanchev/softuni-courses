import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double income = Double.parseDouble(sc.nextLine());
        double points = Double.parseDouble(sc.nextLine());
        double minWage = Double.parseDouble(sc.nextLine());

        double social = 0.0;
        double excellent = 0.0;

        if (income < minWage && points > 4.5) {
            social = minWage * 0.35;
        }
        if (points >= 5.5) {
            excellent = points * 25;
        }

        if (social == 0.0 && excellent == 0.0) {
            System.out.println("You cannot get a scholarship!");
        } else if (social > excellent) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(social));
        } else
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(excellent));


    }
}

