import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String wholeText = "";
        int openCounter = 0;
        int closeCounter = 0;
        boolean isBalanced = true;
        for (int i = 1; i <= num; i++){
            String command = scan.nextLine();

            if (command.equals("(")) {
                openCounter++;
            }
            if (command.equals(")")) {
                closeCounter++;
            }
            if (closeCounter > openCounter) isBalanced = false;
        }
        if (openCounter == closeCounter && isBalanced) System.out.println("BALANCED");
        else System.out.println("UNBALANCED");
    }
}
