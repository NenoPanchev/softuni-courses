import java.math.BigInteger;
import java.util.*;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger firstNum = new BigInteger(scan.nextLine());
        BigInteger secondNum = new BigInteger(scan.nextLine());

        BigInteger sum = firstNum.add(secondNum);
        System.out.println(sum);
    }
}
