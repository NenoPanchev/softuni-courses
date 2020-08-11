import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            String name = scan.nextLine();
            String[] letters = name.split("");
            int currentSum = 0;

            for (int j = 0; j < name.length(); j++) {
                int value = name.charAt(j);
                switch (name.charAt(j)) {
                    case 'A':
                    case 'a':
                    case 'E':
                    case 'e':
                    case 'O':
                    case 'o':
                    case 'U':
                    case 'u':
                    case 'I':
                    case 'i':
                        currentSum += name.charAt(j) * name.length(); break;
                    default:
                        currentSum += name.charAt(j) / name.length(); break;

                }
            }
            arr[i] = currentSum;
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
