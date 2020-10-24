import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeashellTreasure {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matrix = readMatrix(scan);
        List<String> collectedSeashells = new ArrayList<>();
        int stolenSeashells = 0;

        String input = scan.nextLine();
        while (!input.equals("Sunset")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Collect":
                    if (isValidIndex(matrix, row, col)) {
                        String symbol = matrix[row][col];
                        if (!symbol.equals("-")) {
                            collectedSeashells.add(symbol);
                            matrix[row][col] = "-";
                        }
                    }
                    break;

                case "Steal":
                    if (isValidIndex(matrix, row, col)) {
                        String direction = tokens[3];
                        String symbol = matrix[row][col];
                        if (!symbol.equals("-")) {
                            matrix[row][col] = "-";
                            stolenSeashells++;
                        }
                        for (int i = 0; i < 3; i++) {
                            List<Integer> nextPosition = getNextPosition(row, col, direction);
                            row = nextPosition.get(0);
                            col = nextPosition.get(1);
                            if (isValidIndex(matrix, row, col)) {
                                symbol = matrix[row][col];
                                if (!symbol.equals("-")) {
                                    matrix[row][col] = "-";
                                    stolenSeashells++;
                                }
                            }
                        }
                    }
                    break;
            }

            input = scan.nextLine();
        }
        printMatrix(matrix);
        System.out.print("Collected seashells: ");
        if (collectedSeashells.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.printf("%d -> %s%n",
                    collectedSeashells.size(),
                    collectedSeashells.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.println("Stolen seashells: " + stolenSeashells);
    }

    private static String[][] readMatrix(Scanner scan) {
        int sizeOfMatrix = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[sizeOfMatrix][];
        for (int rows = 0; rows < sizeOfMatrix; rows++) {
            matrix[rows] = scan.nextLine().split(" ");
        }
        return matrix;
    }

    private static boolean isValidIndex(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static List<Integer> getNextPosition(int row, int col, String direction) {
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(col);
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
                System.out.printf("%s ", matrix[row][col]);
            }
            System.out.println();
        }
    }
}
