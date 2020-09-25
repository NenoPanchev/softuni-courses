package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Dough {
    private static final List<String> TYPES_OF_FLOUR = new ArrayList<>(List.of("White", "Wholegrain"));
    private static final List<String> TYPES_OF_BAKING = new ArrayList<>(List.of("Crispy", "Chewy", "Homemade"));
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flour, String baking, double grams) throws IllegalArgumentException {
        setFlourType(flour);
        setBakingTechnique(baking);
        setWeight(grams);
    }

    public double calculateCalories() {
        double flourModifier = 0.0;
        switch (this.flourType) {
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
                break;
        }
        double bakingModifier = 0.0;
        switch (this.bakingTechnique) {
            case "Crispy":
                bakingModifier = 0.9;
                break;

            case "Chewy":
                bakingModifier = 1.1;
                break;

            case "Homemade":
                bakingModifier = 1.0;
                break;
        }
        return 2 * flourModifier * bakingModifier * this.weight;
    }

    private void setFlourType(String flourType) {
        if (!TYPES_OF_FLOUR.contains(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!TYPES_OF_BAKING.contains(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
}
