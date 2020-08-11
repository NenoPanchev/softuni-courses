import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());

        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++) {
                for (char k = 97; k < 97 + l; k++) {
                    for (char m = 97; m < 97 + l ; m++) {
                        for (int o = j + 1; o <= n ; o++) {
                            if (o > i)
                            System.out.print("" + i + j + k + m + o + " ");
                        }
                    }
                }
            }
        }
    }
}
