import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int totalSum = 0;
        int topLeft = 0;
        int topRight = 0;
        int botLeft = 0;
        int botRight = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = 0;
                int topLeftNum = matrix[row][col];
                int topRightNum = matrix[row][col + 1];
                int bottomLeftNum = matrix[row + 1][col];
                int bottomRightNum = matrix[row + 1][col + 1];
                sum = topLeftNum + topRightNum + bottomLeftNum + bottomRightNum;
                if (sum > totalSum) {
                    totalSum = sum;
                    topLeft = topLeftNum;
                    topRight = topRightNum;
                    botLeft = bottomLeftNum;
                    botRight = bottomRightNum;
                }
            }
        }
        System.out.printf("%d %d%n" +
                "%d %d%n" +
                "%d%n", topLeft, topRight, botLeft, botRight, totalSum);
    }
    private static int[][] readMatrix(Scanner scan) {
        int[] readLine = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = readLine[0];
        int cols = readLine[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scan.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            System.arraycopy(line, 0, matrix[row], 0, matrix[row].length);
        }
        return matrix;
    }
}
