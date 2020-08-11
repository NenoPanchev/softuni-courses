import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int lineCount = 0;
        int bestTotalOnes = 0;
        int bestConsecutiveOnes = 0;
        int bestSum = 0;
        int bestIndex = Integer.MAX_VALUE;
        int[] bestDNA = new int[num];
        int bestLineNumber = 0;

        while (!command.equals("Clone them!")) {
        int[] dNA = Arrays.stream(command.split("!+"))
                .mapToInt(Integer::parseInt).toArray();

        lineCount++; //Ред
        int onesOnCurrentLine = 0;
        int mostConsecutiveOnes = 1;
        int sum = 0;
        int currentIndex = Integer.MAX_VALUE;

            for (int i = 0; i <dNA.length; i++) {
                if (dNA[i] == 1) {
                    onesOnCurrentLine++;
                }
            }

            if (onesOnCurrentLine > 0) {
                for (int i = 1; i < dNA.length; i++) {
                    if (dNA[i] == dNA[i - 1] && dNA[i] == 1) {
                        mostConsecutiveOnes++;
                        if (mostConsecutiveOnes > bestTotalOnes) {
                            bestTotalOnes = mostConsecutiveOnes;
                        }
                        currentIndex = i - 1;
                    } else mostConsecutiveOnes = 1;
                }
            } // Поредни единици

            for (int i = 0; i < dNA.length; i++) {
                sum += dNA[i];
            }

        if (bestTotalOnes > bestConsecutiveOnes) {
            bestDNA = dNA;
            bestLineNumber = lineCount;
            bestConsecutiveOnes = bestTotalOnes;
            bestSum = sum;
            bestIndex = currentIndex;

        } else if (bestTotalOnes == bestConsecutiveOnes) {
            if (currentIndex < bestIndex) {
                bestDNA = dNA;
                bestLineNumber = lineCount;
                bestSum = sum;
                bestIndex = currentIndex;
            } else if (currentIndex == bestIndex) {
                if (sum > bestSum) {
                    bestDNA = dNA;
                    bestLineNumber = lineCount;
                    bestSum = sum;
                }
            }
        }
        if (bestSum == 0) bestDNA = dNA;

        command = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestLineNumber, bestSum);
        for (int i = 0; i < bestDNA.length; i++) {
            System.out.printf("%d ", bestDNA[i]);
        }
    }
}
