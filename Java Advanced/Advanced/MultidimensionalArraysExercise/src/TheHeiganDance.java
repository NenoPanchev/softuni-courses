import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double damagePerTurn = Double.parseDouble(scan.nextLine());
        int playerHP = 18500;
        double heiganHP = 3000000;
        int[][] matrix = new int[15][15];
        matrix[7][7] = 1;
        int playerRow = 7;
        int playerCol = 7;
        String spell = "";
        int tick = 0;

        while (playerHP > 0) {
            if (tick > 0) {
                playerHP -= 3500;
                tick--;
            }
            heiganHP -= damagePerTurn;

            if (playerHP <= 0 || heiganHP <= 0) {
                break;
            }


            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            spell = tokens[0];
            int posRow = Integer.parseInt(tokens[1]);
            int posCol = Integer.parseInt(tokens[2]);
            if (checkIfHits(matrix, posRow, posCol)) {
                String[] text = move(matrix, playerRow, playerCol, posRow, posCol).split(" ");
                boolean canPlayerMove;
                try {
                    playerRow = Integer.parseInt(text[0]);
                    playerCol = Integer.parseInt(text[1]);
                    canPlayerMove = Boolean.parseBoolean(text[2]);
                } catch (Exception e) {
                    canPlayerMove = Boolean.parseBoolean(text[0]);
                }

                if (canPlayerMove) {
                    for (int row = -1; row < 2; row++) {
                        for (int col = -1; col < 2; col++) {
                            if (posRow + row >= 0 && posRow + row < 15 &&
                                    posCol + col >= 0 && posCol + col < 15 &&
                                    matrix[posRow + row][posCol + col] == 1) {
                                playerRow = row;
                                playerCol = col;
                                break;
                            }

                        }
                    }
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHP -= 3500;
                            tick += 1;
                            spell = "Plague Cloud";
                            break;

                        case "Eruption":
                            playerHP -= 6000;
                            break;
                    }
                }

            }

        }
        if (playerHP <= 0 && heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: Killed by %s%n", spell);
        } else if (playerHP <= 0) {
            System.out.printf("Heigan: %.2f%n", heiganHP);
            System.out.printf("Player: Killed by %s%n", spell);
        } else if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", playerHP);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static boolean checkIfHits(int[][] matrix, int posRow, int posCol) {
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (posRow + row >= 0 && posRow + row < 15 &&
                        posCol + col >= 0 && posCol + col < 15 &&
                        matrix[posRow + row][posCol + col] == 1)
                    return true;
            }
        }
        return false;
    }

    private static String move(int[][] matrix, int playerRow, int playerCol, int posRow, int posCol) {
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (posRow + row >= 0 && posRow + row < 15 &&
                 posCol + col >= 0 && posCol + col < 15 &&
                matrix[posRow + row][posCol + col] == 0)
                    matrix[posRow + row][posCol + col] = 2;
            }
        }
        StringBuilder code = new StringBuilder();
        boolean canPlayerMove = false;
        if (playerRow - 1 >= 0 && playerRow - 1 < 15 && matrix[playerRow - 1][playerCol] == 0) {
            matrix[playerRow - 1][playerCol] = 1;
            matrix[playerRow][playerCol] = 0;
            canPlayerMove = true;
            code.append(playerRow - 1 + " " + playerCol + " ");
        } else if (playerCol + 1 >= 0 && playerCol + 1 < 15 && matrix[playerRow][playerCol + 1] == 0) {
            matrix[playerRow][playerCol + 1] = 1;
            matrix[playerRow][playerCol] = 0;
            canPlayerMove = true;
            code.append(playerRow + " " + (playerCol + 1) + " ");
        } else if (playerRow + 1 >= 0 && playerRow + 1 < 15 && matrix[playerRow + 1][playerCol] == 0) {
            matrix[playerRow + 1][playerCol] = 1;
            matrix[playerRow][playerCol] = 0;
            canPlayerMove = true;
            code.append(playerRow + 1 + " " + playerCol + " ");
        } else if (playerCol - 1 >= 0 && playerCol - 1 < 15 && matrix[playerRow][playerCol - 1] == 0) {
            matrix[playerRow][playerCol - 1] = 1;
            matrix[playerRow][playerCol] = 0;
            canPlayerMove = true;
            code.append(playerRow + " " + (playerCol - 1) + " ");
        }
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (posRow + row >= 0 && posRow + row < 15 &&
                        posCol + col >= 0 && posCol + col < 15 &&
                        matrix[posRow + row][posCol + col] == 2)
                    matrix[posRow + row][posCol + col] = 0;
            }
        }
        code.append(canPlayerMove);
        return code.toString();
    }
}
