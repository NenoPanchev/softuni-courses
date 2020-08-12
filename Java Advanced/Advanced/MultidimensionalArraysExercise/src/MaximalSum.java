import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        int totalSum = 0;
        int topLeft = 0;
        int topMid = 0;
        int topRight = 0;
        int centerLeft = 0;
        int centerMid = 0;
        int centerRight = 0;
        int botLeft = 0;
        int botMid = 0;
        int botRight = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = 0;
                int topLeftNum = matrix[row][col];
                int topMiddleNum = matrix[row][col + 1];
                int topRightNum = matrix[row][col + 2];
                int centerLeftNum = matrix[row + 1][col];
                int centerMiddleNum = matrix[row + 1][col + 1];
                int centerRightNum = matrix[row + 1][col + 2];
                int botLeftNum = matrix[row + 2][col];
                int botMiddleNum = matrix[row + 2][col + 1];
                int botRightNum = matrix[row + 2][col + 2];
                sum = topLeftNum + topMiddleNum + topRightNum + centerLeftNum + centerMiddleNum +
                centerRightNum + botLeftNum + botMiddleNum + botRightNum;
                if (sum > totalSum) {
                    totalSum = sum;
                    topLeft = topLeftNum;
                    topMid = topMiddleNum;
                    topRight = topRightNum;
                    centerLeft = centerLeftNum;
                    centerMid = centerMiddleNum;
                    centerRight = centerRightNum;
                    botLeft = botLeftNum;
                    botMid = botMiddleNum;
                    botRight = botRightNum;
                }
            }
        }
        System.out.printf("Sum = %d%n", totalSum);
        System.out.printf("%d %d %d%n" +
                "%d %d %d%n" +
                "%d %d %d%n", topLeft, topMid, topRight, centerLeft, centerMid, centerRight, botLeft, botMid, botRight);
    }
    private static int[][] readMatrix(Scanner scan) {
        int[] readLine = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = readLine[0];
        int cols = readLine[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
