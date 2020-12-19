package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood{
    private Collection<Gun> models;

    public GangNeighbourhood() {
        this.models = new ArrayList<>();
    }

    public void add(Gun model) {
        if (find(model.getName()) == null) {
            this.models.add(model);
        }
    }

    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    public Gun find(String name) {
        return this.models.stream()
                .filter(gun -> gun.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                playerShootsPlayer(mainPlayer, civilPlayer);
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                playerShootsPlayer(civilPlayer, mainPlayer);
                if (!mainPlayer.isAlive()) {
                    return;
                }
            }
        }
    }

    private void playerShootsPlayer(Player attacker, Player defender) {
        for (Gun model : attacker.getGunRepository().getModels()) {
            while (model.canFire()) {
                int damage = model.fire();
                defender.takeLifePoints(damage);
                if (!defender.isAlive()) {
                    return;
                }
            }
        }
    }
}
