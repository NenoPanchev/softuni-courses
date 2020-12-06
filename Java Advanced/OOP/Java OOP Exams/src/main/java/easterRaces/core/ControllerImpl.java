package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

public class ControllerImpl implements Controller {
    private Repository<Car> cars;
    private Repository<Driver> drivers;
    private Repository<Race> races;


    public ControllerImpl(Repository<Driver> drivers, Repository<Car> cars, Repository<Race> races) {
        this.cars = cars;
        this.drivers = drivers;
        this.races = races;
    }

    @Override
    public String createDriver(String driver) {
        if (drivers.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }
        this.drivers.add(new DriverImpl(driver));
        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (cars.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        this.cars.add(car);
        return String.format(OutputMessages.CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (this.drivers.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        if (this.cars.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.CAR_NOT_FOUND, carModel));
        }
        this.drivers.getByName(driverName).addCar(this.cars.getByName(carModel));
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (this.races.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (this.drivers.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        this.races.getByName(raceName).addDriver(this.drivers.getByName(driverName));
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (this.races.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (this.races.getByName(raceName).getDrivers().size() < 3) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_INVALID, raceName, 3));
        }
        String[] driverNames = this.races.getByName(raceName).getDrivers().stream()
                .sorted((a, b) -> Double.compare(b.getCar().calculateRacePoints(this.races.getByName(raceName).getLaps()),
                        a.getCar().calculateRacePoints(this.races.getByName(raceName).getLaps())))
                .map(Driver::getName)
                .toArray(String[]::new);
        this.drivers.getByName(driverNames[0]).winRace();
        this.races.remove(this.races.getByName(raceName));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, driverNames[0], raceName)).append(System.lineSeparator());
        sb.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, driverNames[1], raceName)).append(System.lineSeparator());
        sb.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, driverNames[2], raceName));
        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        if (this.races.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.RACE_EXISTS, name));
        }
        this.races.add(new RaceImpl(name, laps));
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
