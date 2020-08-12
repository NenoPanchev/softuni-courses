import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] firstMatrix = readCharMatrix(rows, cols, scan);
        char[][] secondMatrix = readCharMatrix(rows, cols, scan);
        char[][] thirdMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                } else
                    thirdMatrix[row][col] = '*';
                System.out.print(thirdMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static char[][] readCharMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            String strippedString = line.replaceAll("\\s+", "");
            char[] charsLine = strippedString.toCharArray();

            System.arraycopy(charsLine, 0, matrix[row], 0, matrix[row].length);
        }

        return matrix;
    }
}
