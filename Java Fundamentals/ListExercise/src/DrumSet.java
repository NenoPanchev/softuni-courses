import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        List<Integer> initialDrumsQuality = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumsQuality = new ArrayList<>(initialDrumsQuality);

        String hitPower = scan.nextLine();

        while (!hitPower.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(hitPower);
            for (int i = 0; i < drumsQuality.size(); i++) {
                if (drumsQuality.get(i) - power > 0)
                    drumsQuality.set(i, drumsQuality.get(i) - power);
                else {
                    if (budget - initialDrumsQuality.get(i) * 3 >= 0) {
                        budget -= (initialDrumsQuality.get(i) * 3);
                        drumsQuality.set(i, initialDrumsQuality.get(i));
                    } else {
                        drumsQuality.remove(i);
                        initialDrumsQuality.remove(i);
                        i--;
                        if (initialDrumsQuality.size() == 0) break;
                    }

                }
            }
            hitPower = scan.nextLine();
        }
        System.out.println(drumsQuality.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}
