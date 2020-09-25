package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    private static final List<String> TOPPING_LIST = new ArrayList<>(List.of("Meat", "Veggies", "Cheese", "Sauce"));
    private String toppingType;
    private double weight;

    public Topping(String topping, double weight) throws IllegalArgumentException {
        setToppingType(topping);
        setWeight(weight);
    }

    public double calculateCalories() {
        double toppingModifier = 0.0;
        switch (this.toppingType) {
            case "Meat":
                toppingModifier = 1.2;
                break;

            case "Veggies":
                toppingModifier = 0.8;
                break;

            case "Cheese":
                toppingModifier = 1.1;
                break;

            case "Sauce":
                toppingModifier = 0.9;
                break;
        }
        return 2 * toppingModifier * this.weight;
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_LIST.contains(toppingType)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }
}
