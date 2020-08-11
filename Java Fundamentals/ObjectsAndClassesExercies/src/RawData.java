import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
        String[] tokens = scan.nextLine().split("\\s+");

        String model = tokens[0];
        int speed = Integer.parseInt(tokens[1]);
        int power = Integer.parseInt(tokens[2]);
        int weight = Integer.parseInt(tokens[3]);
        String cargoType = tokens[4];
        List<Tires> tiresList = new ArrayList<>();
            for (int j = 5; j < 12; j+= 2) {
                int a = j+1;
                Tires tire = new Tires(Double.parseDouble(tokens[j]), Integer.parseInt(tokens[a]));
                tiresList.add(tire);
            }
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, cargoType);
            Car car = new Car(model, engine, cargo, tiresList);
            carList.add(car);
        }

        String input = scan.nextLine();
        if (input.equals("fragile")) {
        List<String> model = new ArrayList<>();
            for (int i = 0; i < carList.size(); i++) {
                if (carList.get(i).getCargo().getCargoType().equals("fragile") &&
                carList.get(i).getTire().get(i).getTirePressure() < 1) {
                model.add(carList.get(i).getModel());
                }
            }
            model.forEach(System.out::println);
        } else if (input.equals("flamable")){
            carList.forEach(e -> {
                if (e.getCargo().getCargoType().equals("flamable") &&
                e.getEngine().getEnginePower() > 250) {
                    System.out.printf("%s%n", e.getModel());
                }
            });
        }

    }
}

class Engine {
    int engineSpeed;
    int enginePower;

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;

    }
}

class Cargo {
    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    int cargoWeight;
    String cargoType;

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}

class Tires {
    double tirePressure;
    int tireAge;

    public double getTirePressure() {
        return tirePressure;
    }

    public int getTireAge() {
        return tireAge;
    }

    public Tires(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;

    }
}

class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tires> tire;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tires> getTire() {
        return tire;
    }

    public void setTire(List<Tires> tire) {
        this.tire = tire;
    }

    public Car(String model, Engine engine, Cargo cargo, List<Tires> tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;

    }
}