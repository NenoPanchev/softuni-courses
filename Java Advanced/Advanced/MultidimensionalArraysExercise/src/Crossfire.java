import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        String input = scan.nextLine();
        while (!"Nuke it from orbit".equals(input)) {
            matrix = bombMatrix(matrix, input);
            input = scan.nextLine();
        }
        printMatrix(matrix);
    }

    private static int[][] readMatrix(Scanner scan) {
        int[] readLine = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = readLine[0];
        int cols = readLine[1];
        int[][] matrix = new int[rows][cols];
        int num = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = num++;
            }
        }
        return matrix;
    }

    private static int[][] bombMatrix(int[][] matrix, String input) {
        int[] coordinates = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = coordinates[0];
        int col = coordinates[1];
        int range = coordinates[2];

        for (int i = -range; i <= range; i++) {
            if (isValid(matrix, row + i, col))
                matrix[row + i][col] = 0;

            if (isValid(matrix, row, col + i))
                matrix[row][col + i] = 0;
        }

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 0) {
                    for (int i = cols + 1; i < matrix[rows].length; i++) {
                        if (matrix[rows][i] >= 1) {
                            matrix[rows][cols] = matrix[rows][i];
                            matrix[rows][i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return matrix;
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

    private static void printMatrix(int[][] matrix) {
        int[][] bombedMatrix = new int[matrix.length][matrix[0].length];
        for (int rows = 0; rows < bombedMatrix.length; rows++) {
            bombedMatrix[rows] = Arrays.stream(Arrays.toString(matrix[rows]).replaceAll("\\b0|[\\[\\],]", "").split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int row = 0; row < bombedMatrix.length; row++) {
            for (int col = 0; col < bombedMatrix[row].length; col++) {
                    System.out.printf("%d ", bombedMatrix[row][col]);
            }
            if (bombedMatrix[row].length != 0)
            System.out.println();
        }
    }
}
