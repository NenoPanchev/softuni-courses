package wildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eat(Food foodType) {
        if (foodType.getClass().getSimpleName().equals("Vegetable")
        ) {
            super.eat(foodType);
        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
