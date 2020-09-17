import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbersToSort = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sorted = mergeSort(numbersToSort);

        for (int i = 0; i < numbersToSort.length; i++) {
            System.out.print(sorted[i] + " ");
        }

    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int halfIdx = arr.length / 2;
        int[] leftHalf = Arrays.copyOfRange(arr, 0, halfIdx);
        int[] rightHalf = Arrays.copyOfRange(arr, halfIdx, arr.length);

        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);

        return mergeTwoSortedArrays(leftHalf, rightHalf);
    }

    private static int[] mergeTwoSortedArrays(int[] firstArr, int[] secondArr) {
        int[] merged = new int[firstArr.length + secondArr.length];

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstArr.length && secondIndex < secondArr.length) {
            int firstElement = firstArr[firstIndex];
            int secondElement = secondArr[secondIndex];

            if (firstElement < secondElement) {
                merged[firstIndex + secondIndex] = firstElement;
                firstIndex++;
            } else {
                merged[firstIndex + secondIndex] = secondElement;
                secondIndex++;
            }
        }

        while (firstIndex < firstArr.length) {
            merged[firstIndex + secondIndex] = firstArr[firstIndex];
            firstIndex++;
        }

        while (secondIndex < secondArr.length) {
            merged[firstIndex + secondIndex] = secondArr[secondIndex];
            secondIndex++;
        }
        return merged;
    }
}
