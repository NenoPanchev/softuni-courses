import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int side = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(side, scan);
        List<Integer> firstDiagonal = new LinkedList<>();
        List<Integer> secondDiagonal = new LinkedList<>();
        for (int i = 0; i < side; i++) {
            firstDiagonal.add(matrix[i][i]);
            secondDiagonal.add(matrix[side - 1 - i][i]);
        }
        System.out.println(firstDiagonal.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(secondDiagonal.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.printf("%d ", value);
        }
        System.out.println();
    }

    private static int[][] readMatrix(int side, Scanner scan) {
        int[][] matrix = new int[side][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
