package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("##.##");
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
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
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if ((this.fuelQuantity + liters) > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }

    public static DecimalFormat getDecimalFormat() {
        return DECIMAL_FORMAT;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format(": %.2f", this.fuelQuantity);
    }
}
