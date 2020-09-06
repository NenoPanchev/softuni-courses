import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scan.nextLine());
        String[][] matrix = readMatrix(sizeOfMatrix, scan);
        List<Integer> currentPosition = new ArrayList<>();
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if (matrix[rows][cols].equals("B")) {
                    currentPosition.add(rows);
                    currentPosition.add(cols);
                }
            }
        }
        boolean lost = false;
        int flowers = 0;
        String direction = scan.nextLine();
        while (!"End".equals(direction)) {
            matrix[currentPosition.get(0)][currentPosition.get(1)] = ".";
            if (isValidIndex(matrix, getNextPosition(currentPosition, direction))) {
                currentPosition = getNextPosition(currentPosition, direction);
                String nextSymbol = matrix[currentPosition.get(0)][currentPosition.get(1)];
                if (nextSymbol.equals("f")) {
                    flowers++;
                    matrix[currentPosition.get(0)][currentPosition.get(1)] = "B";
                } else if (nextSymbol.equals(".")) {
                    matrix[currentPosition.get(0)][currentPosition.get(1)] = "B";
                } else if (nextSymbol.equals("O")) {
                    continue;
                }
            } else {
                lost = true;
                break;
            }

            direction = scan.nextLine();
        }

        if (lost) {
            System.out.println("The bee got lost!");
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }
        printMatrix(matrix);
    }

    private static String[][] readMatrix(int sizeOfMatrix, Scanner scan) {
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];
        for (int rows = 0; rows < sizeOfMatrix; rows++) {
            matrix[rows] = scan.nextLine().split("");
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

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
