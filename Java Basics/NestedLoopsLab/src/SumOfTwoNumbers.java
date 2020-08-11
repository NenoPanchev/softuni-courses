import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = Integer.parseInt(scan.nextLine());
        int max = Integer.parseInt(scan.nextLine());
        int magicNumber = Integer.parseInt(scan.nextLine());

        int counter = 0;
        boolean success = false;

        for (int i = min; i <= max; i++){
            for (int j = min; j <= max; j++){
                counter++;
                if (i + j == magicNumber){
                    success = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, magicNumber);
                    break;
                }

            }

            if (success) break;

        }
        if (success == false)
            System.out.printf("%d combinations - neither equals %d", counter, magicNumber);

    }
}
