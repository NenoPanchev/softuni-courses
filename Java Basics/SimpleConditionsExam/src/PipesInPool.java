import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = Integer.parseInt(sc.nextLine());
        int pipeOne = Integer.parseInt(sc.nextLine());
        int pipeTwo = Integer.parseInt(sc.nextLine());
        double hours = Double.parseDouble(sc.nextLine());

        double pipeOneWork = pipeOne * hours;
        double pipeTwoWork = pipeTwo * hours;

        double totalWork = (pipeOneWork + pipeTwoWork);

        if ((totalWork) > value){
            System.out.printf("For %f hours the pool overflows with %f liters.", hours, (totalWork - value));
        } else {
            double percentsTotal = Math.floor(totalWork / value * 100);
            double percentsOne = Math.floor(pipeOneWork / totalWork * 100);
            double percentsTwo = Math.floor(pipeTwoWork / totalWork * 100);
            System.out.printf("The pool is %.0f%% full. Pipe 1: %.0f%%. Pipe 2: %.0f%%.", percentsTotal, percentsOne, percentsTwo);
        }
    }
}
