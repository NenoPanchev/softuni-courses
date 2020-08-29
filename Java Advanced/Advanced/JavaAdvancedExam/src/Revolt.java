import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scan.nextLine());
        int numberOfCommands = Integer.parseInt(scan.nextLine());
        String[][] matrix = readMatrix(sizeOfMatrix, scan);
        List<Integer> currentPosition = new ArrayList<>();
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if (matrix[rows][cols].equals("f")) {
                    currentPosition.add(rows);
                    currentPosition.add(cols);
                }
            }
        }
        boolean won = false;

        String direction = scan.nextLine();
        for (int i = 0; i < numberOfCommands; i++) {

                String whatsOnNextPosition = matrix[getDirection(currentPosition, direction, sizeOfMatrix).get(0)]
                        [getDirection(currentPosition, direction, sizeOfMatrix).get(1)];
                switch (whatsOnNextPosition) {
                    case "-":
                        if (matrix[currentPosition.get(0)][currentPosition.get(1)].equals("f"))
                        matrix[currentPosition.get(0)][currentPosition.get(1)] = "-";
                        currentPosition = getDirection(currentPosition, direction, sizeOfMatrix);
                        matrix[currentPosition.get(0)][currentPosition.get(1)] = "f";
                        break;

                    case "B":
                        if (!matrix[currentPosition.get(0)][currentPosition.get(1)].equals("-"))
                        matrix[currentPosition.get(0)][currentPosition.get(1)] = "-";
                        currentPosition = getDirection(currentPosition, direction, sizeOfMatrix);
                        i -= 2;
                        continue;

                    case "F":
                        matrix[currentPosition.get(0)][currentPosition.get(1)] = "-";
                        currentPosition = getDirection(currentPosition, direction, sizeOfMatrix);
                        matrix[currentPosition.get(0)][currentPosition.get(1)] = "f";
                        won = true;
                        break;
                }

            if (won || i == numberOfCommands - 1)
                break;
            direction = scan.nextLine();
        }
        if (won) {
            System.out.println("Player won!");
        } else
            System.out.println("Player lost!");
        printMatrix(matrix);
    }


    private static String[][] readMatrix(int sizeOfMatrix, Scanner scan) {
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];
        for (int rows = 0; rows < sizeOfMatrix; rows++) {
            matrix[rows] = scan.nextLine().split("");
        }
        return matrix;
    }

    private static List<Integer> getDirection(List<Integer> initialList, String direction, int size) {
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
            int nextRow = list.get(0);
            int nextCol = list.get(1);

            if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size) {

            switch (direction) {
                case "up":
                    list.set(0, size - 1);
                    break;

                case "down":
                    list.set(0, 0);
                    break;

                case "left":
                    list.set(1, size - 1);
                    break;

                default:
                    list.set(1, 0);
                    break;
            }
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
