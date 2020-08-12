import java.util.*;

public class ParkingSystem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] coordinates = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(coordinates[0]);
        int cols = Integer.parseInt(coordinates[1]);
        Map<Integer, List<Integer>> matrix = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"stop".equals(input)) {
            int[] tokens = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int entryRow = tokens[0];
            int parkRow = tokens[1];
            int parkCol = tokens[2];
            int distance = 0;
            matrix.putIfAbsent(parkRow, new LinkedList<>());
            if (matrix.get(parkRow).size() == cols - 1) {
                System.out.printf("Row %d full%n", parkRow);
            } else {
                if (!matrix.get(parkRow).contains(parkCol)) {
                    matrix.get(parkRow).add(parkCol);
                    distance = Math.abs(parkRow - entryRow) + parkCol + 1;
                    System.out.println(distance);
                } else {
                    lookForClosestPark(matrix, entryRow, parkRow, parkCol, cols);
                }
            }
            input = scan.nextLine();
        }
    }

    private static void lookForClosestPark(Map<Integer, List<Integer>> matrix, int entryRow, int parkRow, int parkCol, int cols) {
        boolean isThereFreeSpace = false;
        int i = 1;
        int distance = 0;
        while (!isThereFreeSpace) {
            if (parkCol - i > 0 && !matrix.get(parkRow).contains(parkCol - i)) {
                isThereFreeSpace = true;
                matrix.get(parkRow).add(parkCol - i);
                distance = Math.abs(parkRow - entryRow) + parkCol - i + 1;
            } else if (parkCol + i < cols && !matrix.get(parkRow).contains(parkCol + i)) {
                isThereFreeSpace = true;
                matrix.get(parkRow).add(parkCol + i);
                distance = Math.abs(parkRow - entryRow) + parkCol + i + 1;
            }
            i++;
        }
        System.out.println(distance);
    }
}
