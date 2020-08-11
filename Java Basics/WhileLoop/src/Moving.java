import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());

        int volume = width * length * height;

        String command = scan.nextLine();
        int sum = 0;

        while (!command.equals("Done")){
            int boxes = Integer.parseInt(command);
            sum += boxes;
            if (sum > volume){break;}
            command = scan.nextLine();
        }
        int diff = Math.abs(sum - volume);
        if (sum <= volume){
            System.out.printf("%d Cubic meters left.", diff);
        } else
            System.out.printf("No more free space! You need %d Cubic meters more.", diff);
    }
}
