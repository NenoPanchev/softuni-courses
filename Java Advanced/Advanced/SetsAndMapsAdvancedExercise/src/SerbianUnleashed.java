import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> venueSingers = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            Pattern pattern = Pattern.compile("(?<Singer>([A-Za-z][A-Za-z]+) ([A-Za-z][A-Za-z]+ )*)@(?<Venue>([A-Za-z][A-Za-z]+) ([A-Za-z]+ )*)(?<Price>\\d+) (?<Count>\\d+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("Singer").trim();
                String venue = matcher.group("Venue").trim();
                int price = Integer.parseInt(matcher.group("Price"));
                int tickets = Integer.parseInt(matcher.group("Count"));
                long money = price * tickets;
                venueSingers.putIfAbsent(venue, new LinkedHashMap<>());
                venueSingers.get(venue).putIfAbsent(singer, (long) 0);
                venueSingers.get(venue).put(singer, venueSingers.get(venue).get(singer) + money);
            }
            input = scan.nextLine();
        }
        venueSingers.entrySet()
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().entrySet()
                            .stream()
                            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
                });
    }
}
