package entity.football;

import entity.football.composite.PlayerStatisticsPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "player_statistics")
@IdClass(PlayerStatisticsPK.class)
public class PlayerStatistics implements Serializable {
    private Game game;
    private Player player;
    private Short scoredGoals;
    private Short playerAssists;
    private Short playedMinutes;

    public PlayerStatistics() {
    }

    @Id
    @ManyToOne
    public Game getGame() {
        return game;
    }

    public PlayerStatistics setGame(Game game) {
        this.game = game;
        return this;
    }

    @Id
    @ManyToOne
    public Player getPlayer() {
        return player;
    }

    public PlayerStatistics setPlayer(Player player) {
        this.player = player;
        return this;
    }

    @Column(name = "scored_goals")
    public Short getScoredGoals() {
        return scoredGoals;
    }

    public PlayerStatistics setScoredGoals(Short scoredGoals) {
        this.scoredGoals = scoredGoals;
        return this;
    }

    @Column(name = "player_assists")
    public Short getPlayerAssists() {
        return playerAssists;
    }

    public PlayerStatistics setPlayerAssists(Short playerAssists) {
        this.playerAssists = playerAssists;
        return this;
    }

    @Column(name = "played_minutes")
    public Short getPlayedMinutes() {
        return playedMinutes;
    }

    public PlayerStatistics setPlayedMinutes(Short playedMinutes) {
        this.playedMinutes = playedMinutes;
        return this;
    }
}
