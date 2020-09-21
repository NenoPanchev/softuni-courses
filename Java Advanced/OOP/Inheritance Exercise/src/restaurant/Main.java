package restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("Lavazza", 1.2);
        System.out.println(coffee.getPrice());
    }
}
