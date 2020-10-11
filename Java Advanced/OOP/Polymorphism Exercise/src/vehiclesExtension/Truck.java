package vehiclesExtension;

public class Truck extends Vehicle {
    private static final double ADDED_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION, tankCapacity);
    }

    @Override
    public String drive(double kilometers) {
        return "Truck" + super.drive(kilometers);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }

    @Override
    public String toString() {
        return "Truck" + super.toString();
    }
}
