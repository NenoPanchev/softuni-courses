import java.util.HashMap;
import java.util.Scanner;

public class NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Integer> mileage = new HashMap<>();
        HashMap<String, Integer> fuel = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] cars = scanner.nextLine().split("\\|");
            String car = cars[0];
            int milL = Integer.parseInt(cars[1]);
            int fuelL = Integer.parseInt(cars[2]);
            mileage.put(car, milL);
            fuel.put(car, fuelL);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];

            switch (command) {

                case "Drive":
                    String car1 = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel1 = Integer.parseInt(tokens[3]);
                    // ? ili =
                    if (fuel.get(car1) < fuel1) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int oldFuel = fuel.get(car1);
                        int newFuel = oldFuel - fuel1;
                        int oldDist = mileage.get(car1);
                        int newDist = oldDist + distance;
                        fuel.put(car1, newFuel);
                        mileage.put(car1, newDist);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car1, distance, fuel1);
                    }
                    if (mileage.get(car1) >= 100000) {
                        System.out.printf("Time to sell the %s!%n", car1);
                        fuel.remove(car1);
                        mileage.remove(car1);
                    }
                    break;
                case "Refuel":
                    String car2 = tokens[1];
                    int fuel2 = Integer.parseInt(tokens[2]);

                    if ((fuel2 + fuel.get(car2)) >= 75) {
                        int fuelToFit = 75 - fuel.get(car2);
                        fuel.put(car2, 75);
                        System.out.printf("%s refueled with %d liters%n", car2, fuelToFit);
                    } else {
                        int currFuel = fuel.get(car2);
                        fuel.put(car2, currFuel+fuel2);
                        System.out.printf("%s refueled with %d liters%n", car2, fuel2);
                    }
                    break;
                case "Revert":
                    String car3 = tokens [1];
                    int decreasedKm = Integer.parseInt(tokens [2]);
                    int currKm = mileage.get(car3);

                    if ((currKm - decreasedKm) < 10000) {
                        mileage.put(car3, 10000);
                    } else {
                        mileage.put( car3, currKm - decreasedKm);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car3, decreasedKm);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        mileage
                .entrySet()
                .stream()
                .sorted((l,r) -> r.getValue() - l.getValue())
                .forEach(e-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        e.getKey(), e.getValue(), fuel.get(e.getKey())));
    }
}