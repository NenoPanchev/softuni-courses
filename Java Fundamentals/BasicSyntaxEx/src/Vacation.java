import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int num = Integer.parseInt(scan.nextLine());
            String typeOfGroup = scan.nextLine();
            String day = scan.nextLine();
            double price = 0;
            double discount = 1;

            switch (typeOfGroup){
                case "Students":
                    switch (day){
                        case "Friday": price = 8.45; break;
                        case "Saturday": price = 9.8; break;
                        case "Sunday": price = 10.46; break;
                    } break;
                case "Business":
                    switch (day){
                        case "Friday": price = 10.9; break;
                        case "Saturday": price = 15.6; break;
                        case "Sunday": price = 16; break;
                    } break;
                case "Regular":
                    switch (day){
                        case "Friday": price = 15; break;
                        case "Saturday": price = 20; break;
                        case "Sunday": price = 22.5; break;
                    } break;
            }

        if (typeOfGroup.equals("Students") && num >= 30) discount = .85;
        if (typeOfGroup.equals("Business") && num >= 100) num-= 10;
        if (typeOfGroup.equals("Regular") && num >= 10 && num <= 20) discount = .95;
        System.out.printf("Total price: %.2f", num * price * discount);
    }
}
