package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        this.players.remove(Validator.validatePlayer(this.players, this.name, playerName));
    }

    public double getRating() {
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0));
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }
}
