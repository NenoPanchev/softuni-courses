import java.util.*;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
        System.out.printf("Number of coins to take: %d%n", usedCoins.values().stream().mapToInt(Integer::intValue).sum());

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getValue() + " coin(s) with value " + usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        coins = Arrays.stream(coins).sorted().toArray();

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoin = coins[i];
            int count = targetSum / currentCoin;
            if (count != 0)
                map.put(currentCoin, count);
            targetSum = targetSum % currentCoin;
        }

        if (targetSum != 0) {
            System.out.println("Error");
            System.exit(1);
        }
        return map;
    }
}
