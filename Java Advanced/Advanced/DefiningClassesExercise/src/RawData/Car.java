package RawData;

import java.util.List;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tires> tire;

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tires> getTire() {
        return tire;
    }

    public Car(String model, Engine engine, Cargo cargo, List<Tires> tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public boolean hasATireWithLowPressure() {
        for (Tires tire : this.tire) {
            if (tire.getTirePressure() < 1)
                return true;
        }
        return false;
    }
}
