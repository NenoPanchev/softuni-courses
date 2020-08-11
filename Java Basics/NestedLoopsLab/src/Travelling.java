import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean count = false;

        double sum = 0;

        while (!count){
           String end = scan.nextLine();
           if (end.equals("End")) break;
           double total = Double.parseDouble(scan.nextLine());
            while (!count){
                double num = Double.parseDouble(scan.nextLine());
                sum += num;
                if (sum >= total){
                    System.out.printf("Going to %s!%n", end);
                    sum = 0;
                    break;
                }
                if (end.equals("End")) break;
            }
        }
    }
}
