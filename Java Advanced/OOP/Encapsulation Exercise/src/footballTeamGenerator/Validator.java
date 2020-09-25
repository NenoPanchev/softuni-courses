package footballTeamGenerator;

import java.util.List;

public class Validator {
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateStat(String statName, int stat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }

    public static Player validatePlayer(List<Player> list, String teamName, String name) {
        for (Player player : list) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new IllegalArgumentException("Player " + name + " is not in " + teamName + " team.");
    }

    public static Team validateTeam(List<Team> list, String teamName) {
        for (Team team : list) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        throw new IllegalArgumentException("Team " + teamName + " does not exist.");
    }
}
