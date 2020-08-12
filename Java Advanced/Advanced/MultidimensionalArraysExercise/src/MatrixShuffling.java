import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matrix = readMatrix(scan);

        while (true) {
                String input = scan.nextLine();
                if (input.equals("END")) {
                    break;
                }
                String[] tokens = input.split("\\s+");
                if (tokens.length != 5 || !"swap".equals(tokens[0])) {
                    System.out.println("Invalid input!");
                    continue;
                }
                String command = tokens[0];
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);
                if (row1 >= 0 && row2 >= 0 && row1 < matrix.length && row2 < matrix.length
                && col1 >=0 && col2 >= 0 && col1 < matrix[row1].length && col2 < matrix[row2].length) {

                    String swap = matrix[row1][col1];
                    String swap2 = matrix[row2][col2];
                    matrix[row2][col2] = swap;
                    matrix[row1][col1] = swap2;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                    continue;
                }
        }

    }

    private static String[][] readMatrix(Scanner scan) {
        int[] readLine = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = readLine[0];
        int cols = readLine[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
        return matrix;
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
