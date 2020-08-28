import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] matrix = readMatrix(scan);
        List<Integer> currentPosition = new ArrayList<>();
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if (matrix[rows][cols].equals("S")) {
                    currentPosition.add(rows);
                    currentPosition.add(cols);
                }
            }
        }

        int foodEaten = 0;
        while (foodEaten != 10) {
            String direction = scan.nextLine();
            matrix[currentPosition.get(0)][currentPosition.get(1)] = ".";
            if (isValidIndex(matrix, getDirection(currentPosition, direction))) {
                currentPosition = getDirection(currentPosition, direction);

                String whatsOnNextPosition = matrix[currentPosition.get(0)][currentPosition.get(1)];
                if (whatsOnNextPosition.equals("B")) {
                    matrix[currentPosition.get(0)][currentPosition.get(1)] = ".";
                    for (int rows = 0; rows < matrix.length; rows++) {
                        for (int cols = 0; cols < matrix.length; cols++) {
                            if (matrix[rows][cols].equals("B")) {
                                matrix[rows][cols] = "S";
                                currentPosition.set(0, rows);
                                currentPosition.set(1, cols);
                            }
                        }
                    }
                } else {
                    if (whatsOnNextPosition.equals("*"))
                        foodEaten++;
                    matrix[currentPosition.get(0)][currentPosition.get(1)] = "S";
                }
            } else {
                break;
            }
        }
        if (foodEaten < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);
        printMatrix(matrix);
    }

    private static String[][] readMatrix(Scanner scan) {
        int num = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[num][];
        for (int rows = 0; rows < num; rows++) {
           matrix[rows] = scan.nextLine().split("");
        }
        return matrix;
    }
    private static boolean isValidIndex(String[][] matrix, List<Integer> list) {
        int nextRow = list.get(0);
        int nextCol = list.get(1);
        return nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix.length;
    }

    private static List<Integer> getDirection(List<Integer> initialList, String direction) {
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
