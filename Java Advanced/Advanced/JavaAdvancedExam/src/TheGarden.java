import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = readMatrix(size, scan);
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("C", 0);
        map.put("P", 0);
        map.put("L", 0);
        int harmedVegetables = 0;

        String input = scan.nextLine();
        while (!"End of Harvest".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            switch (command) {
                case "Harvest":
                    if (isValidPosition(matrix, row, col) && !matrix[row][col].equals(" ")) {
                        map.put(matrix[row][col], map.get(matrix[row][col]) + 1);
                        matrix[row][col] = " ";
                    }
                    break;

                case "Mole":
                    if (isValidPosition(matrix, row, col)) {
                        String direction = tokens[3];
                        switch (direction) {
                            case "up":
                                for (int rows = row; rows >= 0; rows -= 2) {
                                    if (isValidPosition(matrix, rows, col) && !matrix[rows][col].equals(" ")) {
                                        matrix[rows][col] = " ";
                                        harmedVegetables++;
                                    }
                                }
                                break;

                            case "down":
                                for (int rows = row; rows < matrix.length; rows += 2) {
                                    if (isValidPosition(matrix, rows, col) && !matrix[rows][col].equals(" ")) {
                                        matrix[rows][col] = " ";
                                        harmedVegetables++;
                                    }
                                }
                                break;

                            case "left":
                                for (int cols = col; cols >= 0; cols -= 2) {
                                    if (isValidPosition(matrix, row, cols) && !matrix[row][cols].equals(" ")) {
                                        matrix[row][cols] = " ";
                                        harmedVegetables++;
                                    }
                                }
                                break;

                            case "right":
                                for (int cols = col; cols < matrix[row].length; cols += 2) {
                                    if (isValidPosition(matrix, row, cols) && !matrix[row][cols].equals(" ")) {
                                        matrix[row][cols] = " ";
                                        harmedVegetables++;
                                    }
                                }
                                break;
                        }
                    }
                    break;
            }
            input = scan.nextLine();
        }
        printMatrix(matrix);
        System.out.println("Carrots: " + map.get("C"));
        System.out.println("Potatoes: " + map.get("P"));
        System.out.println("Lettuce: " + map.get("L"));
        System.out.println("Harmed vegetables: " + harmedVegetables);

    }

    private static String[][] readMatrix(int sizeOfMatrix, Scanner scan) {
        String[][] matrix = new String[sizeOfMatrix][];
        for (int rows = 0; rows < sizeOfMatrix; rows++) {
            matrix[rows] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static boolean isValidPosition(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
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
