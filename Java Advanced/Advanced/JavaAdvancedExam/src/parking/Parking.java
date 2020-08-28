package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Parking {
    List<Car> data;
    String type;
    int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        Predicate<Car> carPredicate = car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model);

        for (int i = 0; i < this.data.size(); i++) {
            if (carPredicate.test(this.data.get(i))) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.size() == 0) {
            return null;
        } else
        return this.data.stream().min((a, b) -> Integer.compare(b.getYear(), a.getYear())).get();
    }

    public Car getCar(String manufacturer, String model) {
        if (this.data.size() == 0) {
            return null;
        } else
            return this.data.stream()
                    .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                    .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return toString().trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:%n", this.type));
        for (Car car : this.data) {
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }
}
