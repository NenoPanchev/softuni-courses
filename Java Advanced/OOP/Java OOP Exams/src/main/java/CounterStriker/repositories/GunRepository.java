package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class GunRepository implements Repository<Gun> {
    private Map<String, Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models.values();
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_REPOSITORY);
        }
        this.models.put(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        if (this.models.containsKey(model.getName())) {
            this.models.remove(model.getName());
            return true;
        }
        return false;
    }

    @Override
    public Gun findByName(String name) {
        return this.models.get(name);
    }
}
