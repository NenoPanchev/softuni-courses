package vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Vehicle> vehiclesByType = new LinkedHashMap<>();
        double[] values = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();
        vehiclesByType.put("Car", new Car(values[0], values[1]));
        values = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1)
                .mapToDouble(Double::parseDouble)
                .toArray();
        vehiclesByType.put("Truck", new Truck(values[0], values[1]));
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
                    vehiclesByType.get(typeOfVehicle).refuel(value);
                    break;
            }
        }
        for (Vehicle vehicle : vehiclesByType.values()) {
            System.out.println(vehicle);
        }
    }
}
