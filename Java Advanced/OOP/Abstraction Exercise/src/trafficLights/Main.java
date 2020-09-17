package trafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TrafficLight trafficLights = new TrafficLight(scan.nextLine().split("\\s+"));
        int timesToRotateLights = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < timesToRotateLights; i++) {
            trafficLights.changeLights();
            System.out.println(trafficLights);
        }
    }
}
