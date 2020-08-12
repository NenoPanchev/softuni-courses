import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> stackSymbols = new ArrayDeque<>();
        for (String s : input) {
            if (Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {
                System.out.printf("%s ", s);
            } else if (s.equals("(")) {
                stackSymbols.push(s);
            }
            else {
                switch (s) {
                    case "+":
                    case "-":
                        if (!stackSymbols.isEmpty()) {
                            if ((stackSymbols.peek().equals("-") || stackSymbols.peek().equals("+")
                            || (stackSymbols.peek().equals("*") || stackSymbols.peek().equals("/")))) {
                                System.out.printf("%s ", stackSymbols.pop());
                            }
                        }
                        stackSymbols.push(s);
                        break;

                    case "*":
                    case "/":
                        if (!stackSymbols.isEmpty()) {
                            if ((stackSymbols.peek().equals("*") || stackSymbols.peek().equals("/"))) {
                                System.out.printf("%s ", stackSymbols.pop());
                            }
                        }
                        stackSymbols.push(s);
                        break;

                    case ")":
                        while (!stackSymbols.peek().equals("("))
                            System.out.printf("%s ", stackSymbols.pop());
                        stackSymbols.pop();
                        break;
                }
            }
        }
        int stackSize = stackSymbols.size();
        for (int i = 0; i < stackSize; i++) {
            System.out.printf("%s ", stackSymbols.pop());
        }
    }
}
