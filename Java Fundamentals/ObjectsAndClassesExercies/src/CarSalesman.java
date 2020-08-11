import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
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

   private static class Car {
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

       public String getWeight() {
           return weight;
       }

       public void setWeight(String weight) {
           this.weight = weight;
       }

       public String getColor() {
           return color;
       }

       public void setColor(String color) {
           this.color = color;
       }

       String model;
    Engine engine;
    String weight;
    String color;

    Car() {
        this.weight = "n/a";
        this.color = "n/a";
    }

       public Car(String model, Engine engine, String weight, String color) {
           this.model = model;
           this.engine = engine;
           this.weight = weight;
           this.color = color;
       }

       @Override
       public String toString() {
           return String.format("%s:%n" +
                   "%s%n" +
                   "Weight: %s%n" +
                   "Color: %s", this.getModel(), this.getEngine().toString(), this.getWeight(), this.getColor());
       }
   }

    private static class Engine {
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }

        public Engine(String model, int power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }
        Engine() {
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }

        String model;
        int power;
        String displacement;
        String efficiency;

        @Override
        public String toString() {
            return String.format("%s:%n" +
                    "Power: %d%n" +
                    "Displacement: %s%n" +
                    "Efficiency: %s", this.getModel(), this.getPower(), this.getDisplacement(), this.getEfficiency());
        }
    }
}
