package wildFarm;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst(" ", " " + this.breed + ", ");
    }
}
