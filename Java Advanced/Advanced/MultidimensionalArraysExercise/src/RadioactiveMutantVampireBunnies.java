import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] coordinates = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(coordinates[0]);
        int cols = Integer.parseInt(coordinates[1]);
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        int lastRow = 0;
        int lastCol = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("P")) {
                    lastRow = row;
                    lastCol = col;
                }
            }
        }
        String[] directions = scan.nextLine().split("");
        String over = "";
        for (int i = 0; i < directions.length; i++) {
            boolean gameOver = false;
            matrix[lastRow][lastCol] = ".";
            switch (directions[i]) {
                case "U":
                    if (lastRow - 1 < 0) {
                        over = "won";
                    } else {
                        matrix[lastRow][lastCol] = ".";
                        if (matrix[lastRow - 1][lastCol].equals(".")) {
                            matrix[lastRow - 1][lastCol] = "P";
                        } else
                            over = "dead";
                        lastRow -= 1;
                    }
                    break;
                case "D":
                    if (lastRow + 1 >= rows) {
                        over = "won";
                    } else {
                        if (matrix[lastRow + 1][lastCol].equals(".")) {
                            matrix[lastRow + 1][lastCol] = "P";
                        } else
                            over = "dead";
                        lastRow += 1;
                    }
                    break;
                case "L":
                    if (lastCol - 1 < 0) {
                        over = "won";
                    } else {
                        if (matrix[lastRow][lastCol - 1].equals(".")) {
                            matrix[lastRow][lastCol - 1] = "P";
                        } else
                            over = "dead";
                        lastCol -= 1;
                    }
                    break;
                case "R":
                    if (lastCol + 1 >= cols) {
                        over = "won";
                    } else {
                        if (matrix[lastRow][lastCol + 1].equals(".")) {
                            matrix[lastRow][lastCol + 1] = "P";
                        } else
                            over = "dead";
                        lastCol += 1;
                    }
            }

            if (spreadBunniesAndCheckIfDead(matrix)) {
                over = "dead";
            }
            if (over.equals("dead") || over.equals("won"))
                break;
        }
        printMatrix(matrix);
        System.out.printf("%s: %d %d%n", over, lastRow, lastCol);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean spreadBunniesAndCheckIfDead(String[][] matrix) {
        boolean dead = false;
        String[][] secondMatrix = new String[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                secondMatrix[row][col] = matrix[row][col];
            }
        }
        for (int row = 0; row < secondMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                if (secondMatrix[row][col].equals("B")) {
                    if (row - 1 >= 0) {
                        if (secondMatrix[row - 1][col].equals("P")) {
                            dead = true;
                        }
                        matrix[row - 1][col] = "B";
                    }
                    if (row + 1 < secondMatrix.length) {
                        if (secondMatrix[row + 1][col].equals("P"))
                            dead = true;
                        matrix[row + 1][col] = "B";
                    }
                    if (col + 1 < secondMatrix[row].length) {
                        if (secondMatrix[row][col + 1].equals("P"))
                            dead = true;
                        matrix[row][col + 1] = "B";
                    }
                    if (col - 1 >= 0) {
                        if (secondMatrix[row][col - 1].equals("P"))
                            dead = true;
                        matrix[row][col - 1] = "B";
                    }
                }
            }
        }
        return dead;
    }
}
