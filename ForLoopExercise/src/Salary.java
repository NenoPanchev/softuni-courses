import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++){
            String name = scan.nextLine();
            if (name.equals("Facebook")) salary -= 150;
            if (name.equals("Instagram")) salary -= 100;
            if (name.equals("Reddit")) salary -= 50;
            if (salary <= 0) break;
        }
        if (salary > 0) System.out.println(salary);
        else System.out.printf("You have lost your salary.");
    }
}
