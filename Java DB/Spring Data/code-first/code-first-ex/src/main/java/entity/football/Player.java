package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
    private String name;
    private Short squadNumber;
    private Team team;
    private Position position;
    private boolean isInjured;
    private Set<Game> games;

    public Player() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "squad_number")
    public Short getSquadNumber() {
        return squadNumber;
    }

    public Player setSquadNumber(Short squadNumber) {
        this.squadNumber = squadNumber;
        return this;
    }

    @ManyToOne
    public Team getTeam() {
        return team;
    }

    public Player setTeam(Team team) {
        this.team = team;
        return this;
    }

    @ManyToOne
    public Position getPosition() {
        return position;
    }

    public Player setPosition(Position position) {
        this.position = position;
        return this;
    }

    @Column(name = "is_injured")
    public boolean isInjured() {
        return isInjured;
    }

    public Player setInjured(boolean injured) {
        isInjured = injured;
        return this;
    }

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id")
    )
    public Set<Game> getGames() {
        return games;
    }

    public Player setGames(Set<Game> games) {
        this.games = games;
        return this;
    }
}
