package RawData;

public class Cargo {
    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    int cargoWeight;
    String cargoType;

    public String getCargoType() {
        return cargoType;
    }
}
