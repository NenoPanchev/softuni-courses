package vehiclesExtension;

public class Car extends Vehicle {
    private static final double ADDED_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION, tankCapacity);
    }

    @Override
    public String drive(double kilometers) {
        return "Car" + super.drive(kilometers);
    }

    @Override
    public String toString() {
        return "Car" + super.toString();
    }
}
