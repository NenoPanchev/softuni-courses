import java.util.Scanner;

public class NameWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int sum = Integer.MIN_VALUE;
        String maxName = "";

        while (!name.equals("STOP")){
            int currentSum = 0;
            for (int i = 0; i < name.length(); i++){
                int letter = name.charAt(i);
                currentSum += letter;
            }
            if (currentSum > sum){
                sum = currentSum;
                maxName = name;
            }
            name = scan.nextLine();
        }

        System.out.printf("Winner is %s - %d!", maxName, sum);
    }
}
