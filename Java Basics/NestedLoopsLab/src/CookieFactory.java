import java.util.Scanner;

public class CookieFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String command = "";
        boolean flour = false;
        boolean sugar = false;
        boolean eggs = false;

        for (int i = 1; i <= num; i++){

            while (!command.equals("Bake!")){
                command = scan.nextLine();
                if (command.equals("flour")) flour = true;
                if (command.equals("sugar")) sugar = true;
                if (command.equals("eggs")) eggs = true;
                if (command.equals("Bake!") && flour && sugar && eggs){
                    System.out.printf("Baking batch number %d...%n", i);
                    flour = false;
                    sugar = false;
                    eggs = false;
                    command = "";
                    break;
                } else if (command.equals("Bake!") && (!flour || !sugar || !eggs)){
                    System.out.println("The batter should contain flour, eggs and sugar!");
                    command = "";
                }
            }
        }
    }
}
