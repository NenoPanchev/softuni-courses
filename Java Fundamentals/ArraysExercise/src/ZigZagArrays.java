import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String[] firstOutput = new String[num];
        String[] secondOutput = new String[num];

        for (int i = 0; i < num; i++){
            String[] input = scan.nextLine().split(" ");
            if (i % 2 == 0) {
                firstOutput[i] = input[0];
                secondOutput[i] = input[1];
            } else {
                firstOutput[i] = input[1];
                secondOutput[i] = input[0];
            }

        }
        System.out.println(String.join(" ", firstOutput));
        System.out.println(String.join(" ", secondOutput));
    }
}
