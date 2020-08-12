import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int side = Integer.parseInt(scan.nextLine());
        int[][] matrix = readMatrix(side, scan);
        int firstDiagonalSum = 0;
        for (int i = 0; i < side; i++) {
            firstDiagonalSum += matrix[i][i];
        }
        int secondDiagonalSum = 0;
        for (int i = 0; i < side; i++) {
            secondDiagonalSum += matrix[i][side - i - 1];
        }
        int result = Math.abs(firstDiagonalSum - secondDiagonalSum);
        System.out.println(result);
    }
    private static int[][] readMatrix(int side, Scanner scan) {
        int[][] matrix = new int[side][];
        for (int row = 0; row < side; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
