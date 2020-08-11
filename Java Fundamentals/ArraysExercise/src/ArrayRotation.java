import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num % input.length; i++){
            String lastNumber = input[0];

            for (int j = 0; j < input.length - 1; j++) {
                input[j] = input[j + 1];
            }
            input[input.length - 1] = lastNumber;
        }
        System.out.println(String.join( " ", input));
    }
}
