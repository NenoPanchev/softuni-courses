import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        TreeMap<String, TreeSet<String>> userIPs = new TreeMap<>();
        HashMap<String, Integer> userDuration = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);
            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(ip);
            userDuration.putIfAbsent(user, 0);
            userDuration.put(user, userDuration.get(user) + duration);
        }
        userIPs.entrySet()
                .forEach(x -> System.out.printf("%s: %d %s%n", x.getKey(), userDuration.get(x.getKey()), x.getValue().toString()));
    }
}
