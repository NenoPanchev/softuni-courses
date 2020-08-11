import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double rest = Double.parseDouble(scan.nextLine());
        int count = 0;
        String stotinki = String.format("%.0f", Math.floor(rest*100));
        int change = Integer.parseInt(stotinki);

        while (change > 0){
            if (change >= 200){
                change -= 200;
                count++;
            } else if (change >= 100){
                change -= 100;
                count++;
            } else if (change >= 50){
                change -= 50;
                count++;
            } else if (change >= 20){
                change -= 20;
                count++;
            } else if (change >= 10){
                change -= 10;
                count++;
            } else if (change >= 5){
                change -= 5;
                count++;
            } else if (change >= 2){
                change -= 2;
                count++;
            } else if (change >= 1){
                change -= 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
