import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();

        switch (type) {
            case "int": {
                int a = Integer.parseInt(scan.nextLine());
                int b = Integer.parseInt(scan.nextLine());
                int greater = getMax(a,b);
                System.out.println(greater);
            } break;
            case "char": {
                char char1 = scan.nextLine().charAt(0);
                char char2 = scan.nextLine().charAt(0);
                char greater = getMax(char1,char2);
                System.out.println(greater);
            } break;
            case "string": {
                String string1 = scan.nextLine();
                String string2 = scan.nextLine();
                String greater = getMax(string1,string2);
                System.out.println(greater);
            } break;
        }
    }
    static int getMax(int a, int b) {
        if (a > b) return a;
        return b;
    }
    static char getMax(char char1, char char2) {
        if (char1 > char2) return char1;
        return char2;
    }
    static String getMax(String string1, String string2) {
        int c = string1.compareTo(string2);
        if (c > 0) return string1;
        return string2;
    }
}
