package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<Gun>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        if (find(model.getName()) == null) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models.stream()
                .filter(gun -> gun.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
