import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());

        int counter = 0;

        for (int i = 0; i <= num; i++){
            for (int j = 0; j <= num; j++){
                for (int k = 0; k <= num; k++){
                    if (i+j+k == num) {
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
