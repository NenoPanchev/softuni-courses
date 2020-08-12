package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            List<Tires> tiresList = new ArrayList<>();
            for (int j = 5; j < 12; j+= 2) {
                int a = j+1;
                Tires tire = new Tires(Double.parseDouble(tokens[j]), Integer.parseInt(tokens[a]));
                tiresList.add(tire);
            }
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tiresList);
            carList.add(car);
        }

        String input = scan.nextLine();
        if (input.equals("fragile")) {
//            carList.stream()
//                    .filter(car -> car.getCargo().getCargoType().equals("fragile") &&
//                            car.hasATireWithLowPressure())
//                    .forEach(c -> System.out.printf("%s%n", c.getModel()));

            carList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile") &&
                            car.getTire().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                    .forEach(c -> System.out.printf("%s%n", c.getModel()));

        } else if (input.equals("flamable")){
            carList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable") && car.getEngine()
                    .getEnginePower() > 250)
                    .forEach(c -> System.out.printf("%s%n", c.getModel()));
        }
    }
}
