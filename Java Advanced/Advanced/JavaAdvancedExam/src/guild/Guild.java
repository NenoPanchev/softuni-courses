package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    String name;
    int capacity;
    List<Player> roster;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] arr = this.getRoster().stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        
        setRoster(this.getRoster().stream()
                .filter(p -> !p.getClazz().equals(clazz))
                .collect(Collectors.toList()));

        return arr;
    }

    public int count() {
        return this.getRoster().size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.getName()).append(":").append("\n");
        for (Player player : this.getRoster()) {
            sb.append(player).append("\n");
        }
        return sb.toString().trim();
    }

    public String report() {
        return toString().trim();
    }
}
