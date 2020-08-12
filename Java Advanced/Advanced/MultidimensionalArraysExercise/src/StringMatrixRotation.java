import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\(|\\)");
        String command = input[0];
        int angle = Integer.parseInt(input[1]);
        List<String> list = new LinkedList<>();
        int length = 0;
        String line = scan.nextLine();
        while (!"END".equals(line)) {
            list.add(line);
            if (line.length() > length)
                length = line.length();
            line = scan.nextLine();
        }
        char[][] matrix = new char[list.size()][length];
        fillMatrix(matrix, list);
        int timesToRotate = (angle / 90) % 4;
        matrix = rotateMatrix(matrix, timesToRotate);

        printMatrix(matrix);

    }

    private static void fillMatrix(char[][] matrix, List<String> list) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < list.get(row).length())
                    matrix[row][col] = list.get(row).charAt(col);
                else
                    matrix[row][col] = ' ';
            }
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int timesToRotate) {
        for (int i = 0; i < timesToRotate; i++) {
            int rows = matrix[0].length;
            char[][] newMatrix = new char[rows][matrix.length];

            for (int row = 0; row < newMatrix.length; row++) {
                for (int col = 0; col < newMatrix[row].length; col++) {
                    newMatrix[row][col] = matrix[matrix.length - 1 - col][row];
                }
            }
            matrix = newMatrix;
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
