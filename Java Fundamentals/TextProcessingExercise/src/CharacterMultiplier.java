import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split("\\s+");
        String shorter;
        String longer;
        int sum = 0;
        if (s[0].length() <= s[1].length()) {
            shorter = s[0];
            longer = s[1];
        } else {
            shorter = s[1];
            longer = s[0];
        }

        for (int i = 0; i < longer.length(); i++) {
            if (i < shorter.length()) {
                sum += shorter.charAt(i) * longer.charAt(i);
            } else
                sum += longer.charAt(i);
        }
        System.out.println(sum);
    }
}
