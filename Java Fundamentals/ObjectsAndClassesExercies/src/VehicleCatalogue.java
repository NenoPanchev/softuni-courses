import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Vehicle> allVehicles = new ArrayList<>();
        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);
            Vehicle current = new Vehicle(type, model, color, horsepower);
            if (type.equals("car")) {
                cars.add(current);
            } else {
                trucks.add(current);
            }
            allVehicles.add(current);

            input = scan.nextLine();
        }
        String model = scan.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : allVehicles) {
                if (vehicle.model.equals(model)) {
                    System.out.println(vehicle.toString());
                    break;
                }
            }
            model = scan.nextLine();
        }

        double totalCarHorsepower = 0;
        double totalTruckHorsepower = 0;
        for (Vehicle car : cars) {
            totalCarHorsepower += car.horsePower;
        }
        for (Vehicle truck : trucks) {
            totalTruckHorsepower += truck.horsePower;
        }
        double carAverageHP = 0;
        double truckAverageHP = 0;
        if (cars.size() > 0)
        carAverageHP = totalCarHorsepower / cars.size();
        if (trucks.size() > 0)
        truckAverageHP = totalTruckHorsepower / trucks.size();
        System.out.printf("Cars have average horsepower of: %.2f.%n", carAverageHP);
        System.out.printf("Trucks have average horsepower of: %.2f.", truckAverageHP);
    }
}

class Vehicle {
    String type;
    String model;
    String color;
    int horsePower;

    public Vehicle(String type, String model, String color, int horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                        "Model: %s%n" +
                        "Color: %s%n" +
                        "Horsepower: %d", this.type.substring(0, 1).toUpperCase() + type.substring(1), this.model,
                this.color, this.horsePower);
    }
}