import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = readCharMatrix(scan);
        List<String> positions = new LinkedList<>();

        for (int row = 0; row < matrix.length; row++) {
            int rowQ = 0;
            int column = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    rowQ++;
                    column = col;
                }
            }
            if (rowQ == 1) {
                positions.add(row + " " + column);
            }
        }
        if (positions.size() == 1) {
            System.out.println(positions.get(0));
            return;
        } else if (positions.size() > 1) {
            for (int pos = 0; pos < positions.size(); pos++) {
                int[] digits = Arrays.stream(positions.get(pos).split(" ")).mapToInt(Integer::parseInt).toArray();
                int columnQ = 0;
                for (int row = 0; row < 8; row++) {
                    if (matrix[row][digits[1]] == 'q') {
                        columnQ++;
                    }
                }
                if (columnQ > 1) {
                    positions.remove(positions.get(pos));
                    pos--;
                }
            }
            if (positions.size() == 1) {
                System.out.println(positions.get(0));
                return;
            }
        }
        for (int pos = 0; pos < positions.size(); pos++) {
            int[] digits = Arrays.stream(positions.get(pos).split(" ")).mapToInt(Integer::parseInt).toArray();
            int diagonalQ = 0;
            for (int i = 1; i < 8; i++) {
                if (isValid(digits[0] + i, digits[1] + i) && matrix[digits[0] + i][digits[1] + i] == 'q') {
                    diagonalQ++;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (isValid(digits[0] - i, digits[1] - i) && matrix[digits[0] - i][digits[1] - i] == 'q') {
                    diagonalQ++;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (isValid(digits[0] + i, digits[1] - i) && matrix[digits[0] + i][digits[1] - i] == 'q') {
                    diagonalQ++;
                }
            }
            for (int i = 1; i < 8; i++) {
                if (isValid(digits[0] - i, digits[1] + i) && matrix[digits[0] - i][digits[1] + i] == 'q') {
                    diagonalQ++;
                }
            }
            if (diagonalQ > 0) {
                positions.remove(positions.get(pos));
                pos--;
            }
        }
        if (positions.size() == 1)
            System.out.println(positions.get(0));
    }

    private static char[][] readCharMatrix(Scanner scan) {
        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            String strippedString = line.replaceAll("\\s+", "");
            char[] charsLine = strippedString.toCharArray();
            System.arraycopy(charsLine, 0, matrix[row], 0, matrix[row].length);
        }
        return matrix;
    }

    private static boolean isValid(int row, int col) {
        return (row >= 0 && row < 8 && col >= 0 && col < 8  );
    }
}
