import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= num; i++){
            int current = i;
            while ( i > 0){
                sum += i % 10;
                i = i / 10;
            }
            boolean ifSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (ifSpecial)
            System.out.printf("%d -> True%n",current);
            else System.out.printf("%d -> False%n",current);
            sum = 0;
            i = current;
        }
    }
}
