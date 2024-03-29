package oldCounterStriker.repositories;

import oldCounterStriker.common.ExceptionMessages;
import oldCounterStriker.models.players.Player;

import java.util.*;

public class PlayerRepository implements Repository<Player> {
    private List<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models;
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return this.models.remove(model);
    }

    @Override
    public Player findByName(String name) {
        return this.models.stream()
                .filter(player -> player.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
