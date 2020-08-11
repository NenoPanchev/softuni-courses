import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Character> letters = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                int num = Character.getNumericValue(input.charAt(i));
                numbers.add(num);
            }
            else
                letters.add(input.charAt(i));
        }
            String result = "";
        int counter = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            for (int j = 0; j < currentNumber; j++) {
                if (i % 2 == 0 && counter < letters.size())
                    result += letters.get(counter);
                        counter++;
            }
        }
        System.out.println(result);
    }
}
