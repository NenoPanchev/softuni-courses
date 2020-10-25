import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
        List<int[]> coordinates = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("Bloom Bloom Plow")) {
            int[] arr = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            if (isValidIndex(matrix, arr)) {
                coordinates.add(arr);
            } else {
                System.out.println("Invalid coordinates.");
            }
            input = scan.nextLine();
        }
        for (int[] coordinate : coordinates) {
            bloom(matrix, coordinate);
        }
        printMatrix(matrix);

    }

    private static void bloom(int[][] matrix, int[] coordinate) {
        int row = coordinate[0];
        int col = coordinate[1];
        for (int rows = row; rows >= 0; rows--) {
            matrix[rows][col] = matrix[rows][col] + 1;
        }
        for (int rows = row; rows < matrix.length; rows++) {
            if (rows == row) {
                continue;
            }
            matrix[rows][col] = matrix[rows][col] + 1;
        }
        for (int cols = col; cols >= 0; cols--) {
            if (cols == col) {
                continue;
            }
            matrix[row][cols] = matrix[row][cols] + 1;
        }
        for (int cols = col; cols < matrix[row].length; cols++) {
            if (cols == col) {
                continue;
            }
            matrix[row][cols] = matrix[row][cols] + 1;
        }
    }

    private static int[][] readMatrix(Scanner scan) {
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = arr[0];
        int col = arr[1];
        int[][] matrix = new int[row][col];
        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                matrix[rows][cols] = 0;
            }
        }
        return matrix;
    }

    private static boolean isValidIndex(int[][] matrix, int[] arr) {
        int nextRow = arr[0];
        int nextCol = arr[1];
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[nextRow].length;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
