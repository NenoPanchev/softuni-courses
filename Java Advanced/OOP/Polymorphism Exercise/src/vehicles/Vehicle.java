package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##.##");
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double kilometers) {
        if (this.fuelQuantity >= this.fuelConsumption * kilometers) {
            this.fuelQuantity -= this.fuelConsumption * kilometers;
            return String.format(" travelled %s km", DECIMAL_FORMAT.format(kilometers));
        } else {
            return " needs refueling";
        }
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format(": %.2f", this.fuelQuantity);
    }
}
