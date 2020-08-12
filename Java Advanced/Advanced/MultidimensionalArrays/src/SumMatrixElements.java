import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int sumOfAllElements = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sumOfAllElements += matrix[row][col];
            }
        }
        System.out.println(sumOfAllElements);
    }
    private static int[][] readMatrix(Scanner scan) {
        int[] readLine = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = readLine[0];
        int cols = readLine[1];
        System.out.println(rows);
        System.out.println(cols);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scan.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            System.arraycopy(line, 0, matrix[row], 0, matrix[row].length);
        }
        return matrix;
    }
}
