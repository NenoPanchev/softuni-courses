import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        int d = Integer.parseInt(scan.nextLine());

        for (int i = a; i <= b; i++){
            for (int j = a; j <= b; j++){
                for (int k = c; k <= d; k++){
                    for (int l = c; l <= d; l++){
                        if ((i + k) == (j + l) && i != j && k != l){
                            System.out.printf("%d%d%n%d%d%n%n", i, j, l, k);
                        }
                    }
                }
            }
        }
    }
}
