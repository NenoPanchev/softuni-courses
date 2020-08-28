import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = readMatrix(scan);
//        int[][] secondMatrix = new int[matrix.length + matrix[0].length - 1][];
        Map<Integer, List<Integer>> secondMatrix = new LinkedHashMap<>();
        int row = matrix.length - 1;
        int n = 0;
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            secondMatrix.put(n, fillSecondMatrix(matrix, row, col));
            n++;
        }
        for (int rows = matrix.length - 2; rows >= 0; rows--) {
            secondMatrix.put(n, fillSecondMatrix(matrix, rows, 0));
            n++;
        }
        secondMatrix.entrySet()
                .forEach(x -> {
                    System.out.println(String.join(" ", x.getValue().toString()
                            .replaceAll("[\\[\\],]", "")));
                });
    }

    private static List<Integer> fillSecondMatrix(int[][] matrix, int row, int col) {
        List<Integer> list = new LinkedList<>();
        list.add(matrix[row][col]);
        while (row - 1 >= 0 && col + 1 < matrix[row].length) {
            row--;
            col++;
            list.add(matrix[row][col]);
        }
        return list;
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

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
