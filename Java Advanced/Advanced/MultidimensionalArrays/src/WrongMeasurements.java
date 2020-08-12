import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int side = Integer.parseInt(scan.nextLine());
        int[][] inputMatrix = readMatrix(side, scan);
        int[] positionOfWrongNumber = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int wrongNumber = inputMatrix[positionOfWrongNumber[0]][positionOfWrongNumber[1]];
        int[][] outputMatrix = new int[side][];
        for (int row = 0; row < inputMatrix.length; row++) {
           outputMatrix[row] = Arrays.copyOf(inputMatrix[row], inputMatrix[row].length   );
        }
        for (int row = 0; row < inputMatrix.length; row++) {
            for (int col = 0; col < inputMatrix[row].length; col++) {
                if (inputMatrix[row][col] == wrongNumber) {
                    int num = 0;
                    num += neighbourNum(inputMatrix, wrongNumber, row - 1, col);
                    num += neighbourNum(inputMatrix, wrongNumber, row + 1, col);
                    num += neighbourNum(inputMatrix, wrongNumber, row, col - 1);
                    num += neighbourNum(inputMatrix, wrongNumber, row, col + 1);
                    outputMatrix[row][col] = num;
                    inputMatrix[row][col] = wrongNumber;
                }
            }
        }
        for (int row = 0; row < outputMatrix.length; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.printf("%d ", outputMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int side, Scanner scan) {
        int[][] matrix = new int[side][];
        for (int row = 0; row < side; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static int neighbourNum(int[][] matrix, int num, int row, int col) {
        int number = 0;
        if ((row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) && matrix[row][col] != num) {
            number = matrix[row][col];
        }
            return number;
    }
}
