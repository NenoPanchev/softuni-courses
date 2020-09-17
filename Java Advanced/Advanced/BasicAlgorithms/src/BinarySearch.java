import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberToFind = Integer.parseInt(scan.nextLine());

        System.out.println(binarySearch(array, numberToFind));
    }

    private static int binarySearch(int[] arr, int numberToFind) {
        int startIdx = 0;
        int endIdx = arr.length - 1;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (numberToFind == arr[midIdx]) {
                return midIdx;
            } else if (numberToFind > arr[midIdx]) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }
        return -1;
    }
}
