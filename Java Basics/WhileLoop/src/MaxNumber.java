import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int maxNum = Integer.MIN_VALUE;

        while (num > 0){
            int input = Integer.parseInt(scan.nextLine());
            if (input > maxNum){
                maxNum = input;
            }
            num--;
        }
        System.out.println(maxNum);
    }
}
