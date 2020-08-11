import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int steps = 0;

        while (steps < 10000){
           String command = scan.nextLine();
           if (command.equals("Going home")){
               int num = Integer.parseInt(scan.nextLine());
               steps += num;
               break;
           } else {
               int num = Integer.parseInt(command);
               steps += num;
           }
        }
        if (steps < 10000){
            System.out.printf("%d more steps to reach goal.", 10000 - steps);
        }
        else System.out.println("Goal reached! Good job!");
    }
}
