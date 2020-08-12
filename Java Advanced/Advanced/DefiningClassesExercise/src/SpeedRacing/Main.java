package SpeedRacing;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double costPerKM = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, costPerKM);
            cars.add(car);
        }

        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            double kilometers = Double.parseDouble(tokens[2]);
            cars.stream().filter(c -> c.model.equals(model))
                    .findFirst().get().drive(kilometers);

            input = scan.nextLine();
        }

        cars.forEach(System.out::println);
    }
}
