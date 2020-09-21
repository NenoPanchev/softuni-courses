package needForSpeed;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> list = new ArrayList<>();
        Vehicle vehicle = new Vehicle(40, 80);
        Motorcycle motorcycle = new Motorcycle(20, 115);
        RaceMotorcycle suzuki = new RaceMotorcycle(30, 240);
        CrossMotorcycle yamaha = new CrossMotorcycle(25, 150);
        SportCar porche = new SportCar(80, 330);
        list.add(vehicle);
        list.add(motorcycle);
        list.add(suzuki);
        list.add(yamaha);
        list.add(porche);


        for (Vehicle v : list) {
            System.out.println(v.getFuelConsumption());
            v.drive(4);
            System.out.println(v.getFuel());
        }
    }
}
