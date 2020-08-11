import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fruit = sc.nextLine();
        String day = sc.nextLine();
        double quantity = Double.parseDouble(sc.nextLine());
        double price = 0.0;
        boolean isWorkDay = true;
        boolean isWeekDay = true;
        boolean isValidDay = true;
        boolean isValidFruit = true;

        switch (day){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
            case "Saturday":
            case "Sunday":
                break;
            default:
                isValidDay = false; break;
        }
        switch (day){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday": break;
            default: isWorkDay = false; break;
        }
        switch (day){
            case "Saturday":
            case "Sunday": break;
            default: isWeekDay = false;
            break;
        }
        switch (fruit){
            case "banana":
            case "apple":
            case "orange":
            case "grapefruit":
            case "kiwi":
            case "pineapple":
            case "grapes":
                break;
            default:
                isValidFruit = false; break;
        }

        if (isValidDay && isValidFruit){
            switch (fruit){
                case "banana":
                    if (isWorkDay)
                        price = 2.5;
                    else
                        price = 2.7; break;
                case "apple":
                    if (isWorkDay)
                        price = 1.2;
                    else
                        price = 1.25; break;
                case "orange":
                    if (isWorkDay)
                        price = 0.85;
                    else
                        price = 0.9; break;
                case "grapefruit":
                    if (isWorkDay)
                        price = 1.45;
                    else
                        price = 1.6; break;
                case "kiwi":
                    if (isWorkDay)
                        price = 2.7;
                    else
                        price = 3.0; break;
                case "pineapple":
                    if (isWorkDay)
                        price = 5.5;
                    else
                        price = 5.6; break;
                case "grapes":
                    if (isWorkDay)
                        price = 3.85;
                    else
                        price = 4.2; break;

            }
            System.out.printf("%.2f", (price * quantity));
        } else System.out.println("error");
    }
}
