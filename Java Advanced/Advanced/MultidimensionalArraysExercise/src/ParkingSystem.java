import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] coordinates = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(coordinates[0]);
        int cols = Integer.parseInt(coordinates[1]);
        int[][] matrix = new int[rows][cols];
        String input = scan.nextLine();
        while (!"stop".equals(input)) {
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int entryRow = tokens[0];
            int parkRow = tokens[1];
            int parkCol = tokens[2];
            int distance = 0;
            if (matrix[parkRow][parkCol] == 0) {
                matrix[parkRow][parkCol] = 1;
                distance = Math.abs(parkRow - entryRow) + parkCol + 1;
                System.out.println(distance);
            } else {
                lookForClosestPark(matrix, entryRow, parkRow, parkCol);
            }

            input = scan.nextLine();
        }
    }

    private static void lookForClosestPark(int[][] matrix, int entryRow, int parkRow, int parkCol) {
        boolean isThereFreeSpace = false;
        int i = 1;
        int distance = 0;
        while (!isThereFreeSpace) {
            if (parkCol - i > 0 && matrix[parkRow][parkCol - i] == 0) {
                isThereFreeSpace = true;
                matrix[parkRow][parkCol - i] = 1;
                distance = Math.abs(parkRow - entryRow) + parkCol - i + 1;
            } else if (parkCol + i < matrix[0].length && matrix[parkRow][parkCol + i] == 0) {
                isThereFreeSpace = true;
                matrix[parkRow][parkCol + i] = 1;
                distance = Math.abs(parkRow - entryRow) + parkCol + i + 1;
            } else {
                i++;
                if (parkCol - i <= 1 && parkCol + i >= matrix[0].length) {
                    System.out.printf("Row %d full%n", parkRow);
                    return;
                }
            }
        }
        System.out.println(distance);
    }
}
