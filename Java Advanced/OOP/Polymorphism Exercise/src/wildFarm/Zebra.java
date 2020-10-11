package wildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food foodType) {
        if (foodType.getClass().getSimpleName().equals("Vegetable")
        ) {
            super.eat(foodType);
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
