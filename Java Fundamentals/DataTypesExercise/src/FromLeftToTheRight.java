import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= num; i++){
            double left = Double.parseDouble(scan.next());
            double right = Double.parseDouble(scan.next());
            int sum = 0;
            if (left > right){
                double first = Math.abs(left);
                while (first > 0){
                    sum += first % 10;
                    first /= 10;
                }
                System.out.println(sum);
            } else {
                double second = Math.abs(right);
                while (second > 0){
                    sum += second % 10;
                    second /= 10;
                }
                System.out.println(sum);
            }

        }

    }
}
