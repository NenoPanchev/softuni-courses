package SpeedRacing;

public class Car {
    String model;
    double fuel;
    double cost;
    double distance;

    Car(String model, double fuel, double cost) {
        this.model = model;
        this.fuel = fuel;
        this.cost = cost;
        this.distance = 0;
    }

    public double getFuel() {
        return this.fuel;
    }

    public String getModel() {
        return model;
    }

    public double getCost() {
        return cost;
    }

    public double getDistance() {
        return distance;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void drive(double kilometers) {
        if (kilometers * this.getCost() <= this.getFuel()) {
            this.setFuel(this.getFuel() - kilometers * this.getCost());
            this.setDistance(this.getDistance() + kilometers);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuel, this.distance);
    }
}
