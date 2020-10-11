package wildFarm;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d]",
                super.toString(),
                this.livingRegion,
                this.getFoodEaten());
    }
}
