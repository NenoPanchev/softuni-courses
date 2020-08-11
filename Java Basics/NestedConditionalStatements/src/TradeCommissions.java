import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String town = sc.nextLine();
        double sales = Double.parseDouble(sc.nextLine());
        boolean isValidTown = true;
        double percent = 0.0;

        switch (town) {
            case "Sofia":
            case "Varna":
            case "Plovdiv":
                break;
            default:
                isValidTown = false;
                break;
        }

        if (isValidTown && sales >= 0) {
            if (sales >= 0 && sales <= 500) {
                switch (town) {
                    case "Sofia":
                        percent = 5;
                        break;
                    case "Varna":
                        percent = 4.5;
                        break;
                    case "Plovdiv":
                        percent = 5.5;
                        break;
                }
            } else if (sales <= 1000) {
                switch (town) {
                    case "Sofia":
                        percent = 7;
                        break;
                    case "Varna":
                        percent = 7.5;
                        break;
                    case "Plovdiv":
                        percent = 8;
                        break;
                }
            } else if (sales <= 10000) {
                switch (town) {
                    case "Sofia":
                        percent = 8;
                        break;
                    case "Varna":
                        percent = 10;
                        break;
                    case "Plovdiv":
                        percent = 12;
                        break;

                }
            } else if (sales > 1000) {
                switch (town) {
                    case "Sofia":
                        percent = 12;
                        break;
                    case "Varna":
                        percent = 13;
                        break;
                    case "Plovdiv":
                        percent = 14.5;
                        break;
                }
            }
            System.out.printf("%.2f", percent * sales * 0.01);
        }
        else
        System.out.println("error");
    }
}