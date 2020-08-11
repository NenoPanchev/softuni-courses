import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int k = 1;
        while (k <= num){
            System.out.println(k);
            k = 2*k +1;
        }
    }
}
