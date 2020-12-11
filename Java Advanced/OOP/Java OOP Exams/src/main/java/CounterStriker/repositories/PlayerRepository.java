package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerRepository implements Repository<Player> {
    private Map<String, Player> models;

    public PlayerRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models.values();
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        this.models.put(model.getUsername(), model);
    }

    @Override
    public boolean remove(Player model) {
        if (this.models.containsKey(model.getUsername())) {
            this.models.remove(model.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public Player findByName(String name) {
        return this.models.get(name);
    }
}
