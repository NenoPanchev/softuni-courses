package vehicles;

public class Truck extends Vehicle {
    private static final Double ADDED_CONSUMPTION = 1.6;

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION);
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
