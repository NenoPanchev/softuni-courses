import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String initialString = scan.nextLine();
        int sideOfMatrix = Integer.parseInt(scan.nextLine());
        String[][] matrix = readMatrix(scan, sideOfMatrix);

    }

    private static String[][] readMatrix(Scanner scan, int side) {
        String[][] matrix = new String[side][side];
        for (int rows = 0; rows < side; rows++) {
            matrix[rows] = scan.nextLine().split("");
        }
        return matrix;
    }
}
