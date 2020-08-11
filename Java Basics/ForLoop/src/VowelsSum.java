import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int sum = 0;

        for (int i = 0; i < name.length(); i++){
            char letter = name.charAt(i);
            if (letter == 'a')
                sum+= 1;
            if (letter == 'e')
                sum+= 2;
            if (letter == 'i')
                sum+= 3;
            if (letter == 'o')
                sum+= 4;
            if (letter == 'u')
                sum+= 5;
        }
        System.out.println(sum);
    }
}
