package oldCounterStriker.models.field;

import oldCounterStriker.common.OutputMessages;
import oldCounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = new ArrayList<>();
        List<Player> counterTerrorists = new ArrayList<>();
        for (Player player : players) {
            if (player.getClass().getSimpleName().equals("Terrorist")) {
                terrorists.add(player);
            } else {
                counterTerrorists.add(player);
            }
        }
        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()) {
            teamAttacksTheOtherTeam(terrorists, counterTerrorists);
            if (!counterTerrorists.isEmpty()) {
                teamAttacksTheOtherTeam(counterTerrorists, terrorists);
            }
        }
        if (terrorists.isEmpty()) {
            return OutputMessages.COUNTER_TERRORIST_WINS;
        } else {
            return OutputMessages.TERRORIST_WINS;
        }
    }

    private void teamAttacksTheOtherTeam(List<Player> attackers, List<Player> defenders) {
        for (Player attacker : attackers) {

            for (int i = 0; i < defenders.size(); i++) {
                int damage = attacker.getGun().fire();
                if (damage == 0) {
                    break;
                }
                defenders.get(i).takeDamage(damage);

                if (!defenders.get(i).isAlive()) {
                    defenders.remove(i);
                    i--;
                }
            }
        }
    }
}
