import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialPresents = Integer.parseInt(scan.nextLine());
        int presents = initialPresents;
        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = readMatrix(scan, size);
        List<Integer> currentPosition = new ArrayList<>();
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if (matrix[rows][cols].equals("S")) {
                    currentPosition.add(rows);
                    currentPosition.add(cols);
                }
            }
        }

        String direction = scan.nextLine();
        while (!direction.equals("Christmas morning")) {
            matrix[currentPosition.get(0)][currentPosition.get(1)] = "-";
            if (isValidIndex(matrix, getNextPosition(currentPosition, direction))) {
                currentPosition = getNextPosition(currentPosition, direction);
                String nextSymbol = matrix[currentPosition.get(0)][currentPosition.get(1)];
                if (nextSymbol.equals("V")) {
                    presents--;
                } else if (nextSymbol.equals("C")) {
                    presents = bonusGifts(matrix, currentPosition, presents);
                }
                matrix[currentPosition.get(0)][currentPosition.get(1)] = "S";
                if (presents <= 0) {
                    System.out.println("Santa ran out of presents!");
                    break;
                }
            } else {
                System.out.println("Santa ran out of presents!");
                break;
            }
            direction = scan.nextLine();
        }
        printMatrix(matrix);
        int niceKidsLeft = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols].equals("V")) {
                    niceKidsLeft++;
                }
            }
        }
        if (niceKidsLeft == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", initialPresents - presents);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKidsLeft);
        }
    }

    private static String[][] readMatrix(Scanner scan, int num) {
        String[][] matrix = new String[num][num];
        for (int rows = 0; rows < num; rows++) {
            matrix[rows] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
    private static boolean isValidIndex(String[][] matrix, List<Integer> list) {
        int nextRow = list.get(0);
        int nextCol = list.get(1);
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix.length;
    }

    private static List<Integer> getNextPosition(List<Integer> initialList, String direction) {
        List<Integer> list = new ArrayList<>();
        list.add(initialList.get(0));
        list.add(initialList.get(1));
        switch (direction) {
            case "up":
                list.set(0, list.get(0) - 1);
                break;

            case "down":
                list.set(0, list.get(0) + 1);
                break;

            case "left":
                list.set(1, list.get(1) - 1);
                break;

            default:
                list.set(1, list.get(1) + 1);
                break;
        }
        return list;
    }

    private static int bonusGifts(String[][] matrix, List<Integer> currentPosition, int presents) {
        int row = currentPosition.get(0);
        int col = currentPosition.get(1);
        if ((matrix[row][col - 1].equals("X") || matrix[row][col - 1].equals("V")) && presents > 0){
            presents--;
        }
        if ((matrix[row][col + 1].equals("X") || matrix[row][col + 1].equals("V")) && presents > 0){
            presents--;
        }
        if ((matrix[row - 1][col].equals("X") || matrix[row - 1][col].equals("V")) && presents > 0){
            presents--;
        }
        if ((matrix[row + 1][col].equals("X") || matrix[row + 1][col].equals("V")) && presents > 0){
            presents--;
        }
        matrix[row][col - 1] = "-";
        matrix[row][col + 1] = "-";
        matrix[row - 1][col] = "-";
        matrix[row + 1][col] = "-";
        return presents;
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
