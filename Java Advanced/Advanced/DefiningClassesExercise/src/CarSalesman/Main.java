package CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Engine engine = new Engine();
            engine.setModel(tokens[0]);
            engine.setPower(Integer.parseInt(tokens[1]));
            switch (tokens.length) {
                case 3: {
                    try {
                        int displacement = Integer.parseInt(tokens[2]);
                        engine.setDisplacement(tokens[2]);
                    } catch (Exception e) {
                        engine.setEfficiency(tokens[2]);
                    }
                } break;
                case 4: {
                    engine.setEfficiency(tokens[3]);
                    engine.setDisplacement(tokens[2]);
                } break;
            }
            engineList.add(engine);
        }

        int n = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Car car = new Car();
            car.setModel(tokens[0]);
            car.setEngine((Engine) engineList.stream().filter(x -> x.getModel().equals(tokens[1]))
                    .findFirst().get());
            switch (tokens.length) {
                case 3: {
                    try {
                        int weight = Integer.parseInt(tokens[2]);
                        car.setWeight(tokens[2]);
                    } catch (Exception e) {
                        car.setColor(tokens[2]);
                    }
                } break;
                case 4: {
                    car.setWeight(tokens[2]);
                    car.setColor(tokens[3]);
                } break;
            }
            carList.add(car);
        }

        carList.forEach(System.out::println);
    }
}
