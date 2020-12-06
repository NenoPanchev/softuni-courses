package easterRaces.repositories;

import easterRaces.entities.racers.Race;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;

public class RaceRepository implements Repository<Race> {
    private Map<String, Race> models;

    public RaceRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Race model) {
        this.models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Race model) {
        if (this.models.containsKey(model.getName())) {
            this.models.remove(model.getName());
            return true;
        }
        return false;
    }
}
