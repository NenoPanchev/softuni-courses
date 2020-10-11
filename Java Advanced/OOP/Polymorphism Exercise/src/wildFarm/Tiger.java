package wildFarm;

public class Tiger extends Feline {
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food foodType) {
        if (foodType.getClass().getSimpleName().equals("Meat")
        ) {
            super.eat(foodType);
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
