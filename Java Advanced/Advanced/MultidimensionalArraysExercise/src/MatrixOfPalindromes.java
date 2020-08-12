import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix);
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = fillCell(row, col);
            }
        }
    }

    private static String fillCell(int row, int col) {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                letters.append((char) (row + 'a'));
            } else
                letters.append((char) (row+col + 'a'));
        }
        return letters.toString();
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
