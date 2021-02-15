package entities.football_betting_database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position {
    private String id;
    private String description;
    private Set<Player> players;

    public Position() {
    }

    @Id
    @Column(length = 2)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase();
    }


    @Column(name = "position_description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "position", targetEntity = Player.class)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
