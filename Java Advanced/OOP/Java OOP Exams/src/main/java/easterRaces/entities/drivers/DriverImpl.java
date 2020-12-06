package easterRaces.entities.drivers;

import easterRaces.common.ExceptionMessages;
import easterRaces.entities.cars.Car;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
        this.car = null;
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
        }
        this.setCar(car);
        this.setCanParticipate();
    }

    @Override
    public void winRace() {
        this.increaseNumberOfWins();
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    private void increaseNumberOfWins() {
        this.numberOfWins = this.getNumberOfWins() + 1;
    }

    private void setCar(Car car) {
        this.car = car;
    }

    private void setCanParticipate() {
        this.canParticipate = true;
    }
}
