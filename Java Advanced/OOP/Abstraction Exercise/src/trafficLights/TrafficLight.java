package trafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrafficLight {

    private List<Light> lights;

    public TrafficLight(String... light) {
        this.lights = Arrays.stream(light)
                .map(Light::valueOf)
                .collect(Collectors.toList());
    }

    public void changeLights() {
        for (int i = 0; i < this.lights.size(); i++) {
            lights.set(i, changeCurrentLight(lights.get(i)));
        }
    }

    private Light changeCurrentLight(Light light) {
        switch (light) {
            case RED:
                return Light.GREEN;
            case GREEN:
                return Light.YELLOW;
            default:
                return Light.RED;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.lights.forEach(light -> sb.append(light).append(" "));
        return sb.toString();
    }
}
