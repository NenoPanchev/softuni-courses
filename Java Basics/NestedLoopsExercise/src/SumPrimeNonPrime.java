import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;
        while (!command.equals("stop")) {
            if (command.equals("stop")) break;
            int currentNumber = Integer.parseInt(command);
            boolean isPrime = true;
            if (currentNumber == 1) isPrime = false;
            else {
                for (int i = currentNumber; i >= 2; i--) {
                    if (currentNumber % i == 0 && i != currentNumber) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (currentNumber < 0) {
                System.out.println("Number is negative.");
            }
            else if (isPrime) sumPrime += currentNumber;
            else if (!isPrime) sumNonPrime += currentNumber;
            command = scan.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d", sumNonPrime);
    }

}
