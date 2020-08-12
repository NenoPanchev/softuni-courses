import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] text = scan.nextLine().toCharArray();
        TreeMap<Character, Integer> symbolCount = new TreeMap<>();
        for (char c : text) {
            symbolCount.putIfAbsent(c, 0);
            symbolCount.put(c, symbolCount.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> c : symbolCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", c.getKey(), c.getValue());
        }
    }
}
