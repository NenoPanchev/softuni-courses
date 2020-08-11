import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        List<Car> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            String[] arr = scan.nextLine().split("\\|");
            Car currentCar = new Car();
            currentCar.setModel(arr[0]);
            currentCar.setMileage(Integer.parseInt(arr[1]));
            currentCar.setFuel(Integer.parseInt(arr[2]));
            list.add(currentCar);
        }
        String input = scan.nextLine();

        while (!input.equals("Stop")) {
            String[] token = input.split(" : ");
            String command = token[0];
            String model = token[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(token[2]);
                    int fuel = Integer.parseInt(token[3]);

                    for (Car car : list) {
                        if (car.getModel().equals(model)) {
                            if (car.getFuel() < fuel)
                                System.out.println("Not enough fuel to make that ride");
                            else {
                                car.setMileage(car.getMileage() + distance);
                                car.setFuel(car.getFuel() - fuel);
                                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                        car.getModel(), distance, fuel);
                            }
                            if (car.getMileage() >= 100000) {
                                System.out.printf("Time to sell the %s!%n", car.getModel());
                                list.remove(car);
                            }
                        }
                    }
                    break;

                case "Refuel":
                    int addedFuel = Integer.parseInt(token[2]);
                    for (Car car : list) {
                        if (car.getModel().equals(model)) {
                            if (car.getFuel() + addedFuel > 75) {
                                addedFuel = 75 - car.getFuel();
                            }
                            car.setFuel(car.getFuel() + addedFuel);
                            System.out.printf("%s refueled with %d liters%n", car.getModel(), addedFuel);
                        }
                    }
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(token[2]);
                    for (Car car : list) {
                        if (car.getModel().equals(model)) {
                            car.setMileage(car.getMileage() - kilometers);
                            if (car.getMileage() < 10000) {
                                car.setMileage(10000);
                            }
                            else
                                System.out.printf("%s mileage decreased by %d kilometers%n", car.getModel(), kilometers);
                        }
                    }
                    break;
            }

            input = scan.nextLine();
        }
        list.stream()
                .sorted((a, b) -> {
                    int sort = 0;
                    if (b.getMileage() == a.getMileage())
                        sort = a.getModel().compareTo(b.getModel());
                    else sort = Integer.compare(b.getMileage(), a.getMileage());
                    return sort;
                })
                .forEach(System.out::println);
    }
}

class Car {
    String model;
    int mileage;
    int fuel;

    public Car(String model, int mileage, int fuel) {
        this.model = model;
        this.mileage = mileage;
        this.fuel = fuel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    public Car(){}

    @Override
    public String toString() {
        return this.getModel() + " -> Mileage: " + this.getMileage() + " kms, Fuel in the tank: " + this.getFuel() + " lt.";
    }
}

