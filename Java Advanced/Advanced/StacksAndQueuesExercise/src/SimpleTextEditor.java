import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> undoStack = new ArrayDeque<>();
        undoStack.push(text.toString());

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    text.append(tokens[1]);
                    undoStack.push(text.toString());
                    break;

                case "2":
                    int numOfLettersToBeRemoved = Integer.parseInt(tokens[1]);
                    text.replace(text.length() - numOfLettersToBeRemoved, text.length(), "");
                    undoStack.push(text.toString());
                    break;

                case "3":
                    int index = Integer.parseInt(tokens[1]) - 1;
                    System.out.println(text.substring(index, index + 1));
                    break;

                case "4":
                    undoStack.pop();
                    text.replace(0, text.length(), undoStack.peek());
                    break;
            }
        }
    }
}
