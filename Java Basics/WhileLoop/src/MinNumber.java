import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int minNum = Integer.MAX_VALUE;

        while (num > 0){
            int input = Integer.parseInt(scan.nextLine());
            if (input < minNum){
                minNum = input;
            }
            num--;
        }
        System.out.println(minNum);
    }
}
