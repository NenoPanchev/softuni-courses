package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Collection<Player> civilPlayers;
    private Repository<Gun> gunRepository;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;

            case "Rifle":
                gun = new Rifle(name);
                break;

            default:
                return ConstantMessages.GUN_TYPE_INVALID;
        }
        this.gunRepository.add(gun);
        return String.format(ConstantMessages.GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = null;
        if (!this.gunRepository.getModels().isEmpty()) {
            for (Gun model : this.gunRepository.getModels()) {
                gun = model;
                break;
            }
            if (name.equals("Vercetti")) {
                this.gunRepository.remove(gun);
                this.mainPlayer.getGunRepository().add(gun);
                return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
            } else {
                for (Player civilPlayer : this.civilPlayers) {
                    if (civilPlayer.getName().equals(name)) {
                        this.gunRepository.remove(gun);
                        civilPlayer.getGunRepository().add(gun);
                        return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
                    }
                }
                return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
            }
        }

        return ConstantMessages.GUN_QUEUE_IS_EMPTY;
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);

        boolean noInjuries = true;
        if (mainPlayer.getLifePoints() != 100) {
            noInjuries = false;
        }

        for (Player civilPlayer : this.civilPlayers) {
            if (civilPlayer.getLifePoints() != 50) {
                noInjuries = false;
                break;
            }
        }
        if (noInjuries) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator());
            int deadCivilPlayers = this.civilPlayers.stream()
                    .filter(player -> !player.isAlive())
                    .toArray(Player[]::new)
                    .length;
            int alivePlayers = this.civilPlayers.stream()
                    .filter(Player::isAlive)
                    .toArray(Player[]::new)
                    .length;
            sb.append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers))
            .append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, alivePlayers)).append(System.lineSeparator());

            return sb.toString().trim();
        }
    }
}
