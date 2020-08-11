import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());
        System.out.println(repeatString(name, num));
    }
    static String repeatString(String name, int num) {
        String result = "";
        for (int i = 0; i < num; i++) {
            result += name;
        }
        return result;
    }
}
