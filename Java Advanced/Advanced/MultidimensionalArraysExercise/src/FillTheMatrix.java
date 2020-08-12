import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] tokens = input.split(",\\s+");
        int side = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];
        int[][] matrix = new int[side][side];
        switch (pattern) {
            case "A":
                fillMatrixPatternA(matrix);
                break;

            case "B":
                fillMatrixPatternB(matrix);
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 != 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = num;
                    num++;
                }
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
    }
}
