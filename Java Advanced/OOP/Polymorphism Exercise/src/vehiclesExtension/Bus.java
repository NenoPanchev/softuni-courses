package vehiclesExtension;

public class Bus extends Vehicle {
    private static final double ADDED_CONSUMPTION = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDED_CONSUMPTION, tankCapacity);
    }

    public String driveEmpty(double kilometers) {
        if (this.getFuelQuantity() >= (this.getFuelConsumption() - ADDED_CONSUMPTION) * kilometers) {
            setFuelQuantity(this.getFuelQuantity() - (this.getFuelConsumption() - ADDED_CONSUMPTION) * kilometers);
            return String.format("Bus travelled %s km", getDecimalFormat().format(kilometers));
        } else {
            return "Bus needs refueling";
        }
    }

    @Override
    public String drive(double kilometers) {
        return "Bus" + super.drive(kilometers);
    }

    @Override
    public String toString() {
        return "Bus" +  super.toString();
    }
}
