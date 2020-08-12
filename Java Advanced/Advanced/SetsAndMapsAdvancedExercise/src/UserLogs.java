import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> userIPComments = new TreeMap<>();
        while (!"end".equals(input)) {
            String[] split = input.split("\\s+");
            String ipAddress = split[0].substring(split[0].indexOf("=") + 1);
            String user = split[2].substring(split[2].indexOf("=") + 1);
            userIPComments.putIfAbsent(user, new LinkedHashMap<>());
            userIPComments.get(user).putIfAbsent(ipAddress, 0);
            userIPComments.get(user).put(ipAddress, userIPComments.get(user).get(ipAddress) + 1);
            input = scan.nextLine();
        }
        userIPComments.entrySet()
                .forEach(x -> {
                    System.out.printf("%s:%n", x.getKey());
                    int i = 1;
                    for (Map.Entry<String, Integer> s : x.getValue().entrySet()) {
                        System.out.printf("%s => %d", s.getKey(), s.getValue());
                        if (i < x.getValue().size())
                            System.out.print(", ");
                        else
                            System.out.println(".");
                        i++;
                    }

                });

    }
}
