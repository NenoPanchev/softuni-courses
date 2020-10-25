package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) &&
                    car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        return this.data.stream()
                .sorted((first, second) -> Integer.compare(second.getYear(), first.getYear()))
                .findFirst()
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) &&
                        car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The cars are parked in %s:%n",
                this.type));
        this.data.forEach(car -> sb.append(car).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
