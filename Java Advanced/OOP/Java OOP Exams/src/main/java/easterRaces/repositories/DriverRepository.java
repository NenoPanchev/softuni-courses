package easterRaces.repositories;

import easterRaces.entities.drivers.Driver;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;

public class DriverRepository implements Repository<Driver> {
    private Map<String, Driver> models;

    public DriverRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Driver getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Driver model) {
        this.models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Driver model) {
        if (this.models.containsKey(model.getName())) {
            this.models.remove(model.getName());
            return true;
        }
        return false;
    }
}
