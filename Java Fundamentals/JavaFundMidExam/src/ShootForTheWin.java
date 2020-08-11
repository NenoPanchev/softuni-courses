import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String indexToBeShot = scan.nextLine();
        int totalShotTargets = 0;
        while (!indexToBeShot.equals("End")) {
            int index = Integer.parseInt(indexToBeShot);

            if (index >= 0 && index < targets.size()) {
                for (int i = 0; i < targets.size(); i++) {
                    if (i == index || targets.get(i) == -1)
                        continue;

                    if (targets.get(i) > targets.get(index) && targets.get(i) != -1)
                        targets.set(i, targets.get(i) - targets.get(index));
                    else if (targets.get(i) <= targets.get(index) && targets.get(i) != -1)
                        targets.set(i, targets.get(i) + targets.get(index));
                }
                totalShotTargets++;
                targets.set(index, -1);
            }

            indexToBeShot = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", totalShotTargets);
        targets.forEach(x -> System.out.printf("%d ", x));
    }
}
