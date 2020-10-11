package vehiclesExtension;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Vehicle> vehiclesByType = new LinkedHashMap<>();
        double[] values = readValues(scan);
        vehiclesByType.put("Car", new Car(values[0], values[1], values[2]));
        values = readValues(scan);
        vehiclesByType.put("Truck", new Truck(values[0], values[1], values[2]));
        values = readValues(scan);
        vehiclesByType.put("Bus", new Bus(values[0], values[1], values[2]));
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];
            String typeOfVehicle = input[1];
            double value = Double.parseDouble(input[2]);

            switch (command) {
                case "Drive":
                    System.out.println(vehiclesByType.get(typeOfVehicle).drive(value));
                    break;

                case "Refuel":
                    try {
                        vehiclesByType.get(typeOfVehicle).refuel(value);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "DriveEmpty":
                    Bus bus = (Bus) vehiclesByType.get(typeOfVehicle);
                    System.out.println(bus.driveEmpty(value));
            }
        }
        for (Vehicle vehicle : vehiclesByType.values()) {
            System.out.println(vehicle);
        }
    }

    private static double[] readValues(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
