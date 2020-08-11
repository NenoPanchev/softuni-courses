import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;
        double discountStudio = 1;
        double discountApartment = 1;

        switch (month){
            case "May":
            case "October":
                priceStudio = 50;
                priceApartment = 65; break;
            case "June":
            case "September":
                priceApartment = 68.7;
                priceStudio = 75.2; break;
            case "July":
            case "August":
                priceStudio = 76;
                priceApartment = 77; break;

        }
        if (days > 7 && days <= 14 && (month.equals("May") || month.equals("October")))
            discountStudio = .95;
        else  if (days > 14 && (month.equals("May") || month.equals("October")))
            discountStudio = .7;
        else if (days > 14 && (month.equals("June") || month.equals("September")))
            discountStudio = .8;
        if (days > 14)
            discountApartment = .9;

        System.out.printf("Apartment: %.2f lv.", days * priceApartment * discountApartment);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", days * priceStudio * discountStudio);
    }
}
