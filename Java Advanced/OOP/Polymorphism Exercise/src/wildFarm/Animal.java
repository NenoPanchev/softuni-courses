package wildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##.##");
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract String makeSound();

    public void eat(Food foodType) {
        this.foodEaten += foodType.getQuantity();
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s",
                this.animalType,
                this.animalName,
                DECIMAL_FORMAT.format(this.animalWeight));
    };
}
