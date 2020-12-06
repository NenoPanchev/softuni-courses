package easterRaces.repositories;

import easterRaces.entities.cars.Car;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;

public class CarRepository implements Repository<Car> {
    private Map<String, Car> models;

    public CarRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Car model) {
        this.models.putIfAbsent(model.getModel(), model);
    }

    @Override
    public boolean remove(Car model) {
        if (this.models.containsKey(model.getModel())) {
            this.models.remove(model.getModel());
            return true;
        }
        return false;
    }
}
