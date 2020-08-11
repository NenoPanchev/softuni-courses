import java.util.Scanner;

public class ExtractPersonInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            int nameStart = input.indexOf('@') + 1;
            int nameEnd = input.indexOf('|');
            int ageStart = input.indexOf('#') + 1;
            int ageEnd = input.indexOf('*');
            String name = input.substring(nameStart, nameEnd);
            String age = input.substring(ageStart, ageEnd);
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
