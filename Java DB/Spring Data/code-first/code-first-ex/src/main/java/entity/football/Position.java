package entity.football;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    private String initials;
    private String positionDescription;
    private Set<Player> players;

    public Position() {
    }

    @Column(nullable = false, columnDefinition = "CHAR(2)")
    public String getInitials() {
        return initials;
    }

    public Position setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    @Column(name = "position_description")
    public String getPositionDescription() {
        return positionDescription;
    }

    public Position setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
        return this;
    }

    @OneToMany(mappedBy = "position")
    public Set<Player> getPlayers() {
        return players;
    }

    public Position setPlayers(Set<Player> players) {
        this.players = players;
        return this;
    }
}
