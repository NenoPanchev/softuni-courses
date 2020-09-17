package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);
        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] ivoPosition = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            evilDestroysStars(matrix, evilPosition);

            sum += ivoCollectsStars(matrix, ivoPosition);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static void evilDestroysStars(int[][] matrix, int[] evilPosition) {
        int evilRow = evilPosition[0];
        int evilCol = evilPosition[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (isValidPosition(matrix, evilRow, evilCol)) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long ivoCollectsStars(int[][] matrix, int[] ivoPosition) {
        long sum = 0;
        int ivoRow = ivoPosition[0];
        int ivoCol = ivoPosition[1];

        while (ivoRow >= 0 && ivoCol < matrix[0].length) {
            if (isValidPosition(matrix, ivoRow, ivoCol)) {
                sum += matrix[ivoRow][ivoCol];
            }

            ivoCol++;
            ivoRow--;
        }
        return sum;
    }

    private static boolean isValidPosition(int[][] matrix, int ivoRow, int ivoCol) {
        return ivoRow >= 0 && ivoRow < matrix.length && ivoCol >= 0 && ivoCol < matrix[0].length;
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
