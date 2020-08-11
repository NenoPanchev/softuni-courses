import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputFirst = scan.nextLine().split(" ");
        String[] inputSecond = scan.nextLine().split(" ");
        for (String first : inputSecond) {
            for (String sec : inputFirst) {
                if (first.equals(sec)){
                    System.out.print(first + " ");
                }
            }
        }
    }
}
