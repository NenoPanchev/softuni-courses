import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> boxesWithMaterials = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(boxesWithMaterials::push);

        ArrayDeque<Integer> magicValue = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int doll = 0;
        int train = 0;
        int bear = 0;
        int bicycle = 0;
        boolean winCondition = false;

        while (!boxesWithMaterials.isEmpty() && !magicValue.isEmpty()) {
            int box = boxesWithMaterials.peek();
            int magic = magicValue.peek();
            if (box == 0 || magic == 0) {
                if (box == 0){
                    boxesWithMaterials.pop();
                }
                if (magic == 0) {
                    magicValue.poll();
                    continue;
                }
                continue;
            }

            int product = box*magic;
            switch (product) {
                case 400:
                    bicycle++;
                    boxesWithMaterials.pop();
                    magicValue.poll();
                    break;

                case 300:
                    bear++;
                    boxesWithMaterials.pop();
                    magicValue.poll();
                    break;

                case 250:
                    train++;
                    boxesWithMaterials.pop();
                    magicValue.poll();
                    break;

                case 150:
                    doll++;
                    boxesWithMaterials.pop();
                    magicValue.poll();
                    break;

                default:
                    if (product < 0) {
                        boxesWithMaterials.push(boxesWithMaterials.pop() + magicValue.poll());
                    } else {
                        magicValue.poll();
                        boxesWithMaterials.push(boxesWithMaterials.pop() + 15);
                    }
                    break;
            }
            if ((doll >= 1 && train >= 1) || (bear >= 1 && bicycle >= 1)){
                winCondition = true;
            }
        }
        if (winCondition) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!boxesWithMaterials.isEmpty()) {
            System.out.printf("Materials left: %s%n", boxesWithMaterials.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicValue.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicValue.stream()
                    .map(String::valueOf).collect(Collectors.joining(", ")));
        }
        TreeMap<String, Integer> toyAmount = new TreeMap<>();
        if (doll != 0) {
            toyAmount.put("Doll", doll);
        }
        if (train != 0) {
            toyAmount.put("Wooden train", train);
        }
        if (bear != 0) {
            toyAmount.put("Teddy bear", bear);
        }
        if (bicycle != 0) {
            toyAmount.put("Bicycle", bicycle);
        }
        toyAmount.entrySet()
                .forEach(toy -> System.out.printf("%s: %d%n", toy.getKey(), toy.getValue()));
    }
}
