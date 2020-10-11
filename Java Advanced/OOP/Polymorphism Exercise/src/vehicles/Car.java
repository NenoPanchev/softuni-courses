package vehicles;

public class Car extends Vehicle {
    private static final Double ADDED_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION);
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
