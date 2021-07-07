package entity.football;

import entity.football.composite.PlayerStatisticsPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistics implements Serializable {
    private PlayerStatisticsPK playerStatisticsPK;
    private Short scoredGoals;
    private Short playerAssists;
    private Short playedMinutes;

    public PlayerStatistics() {
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

    @EmbeddedId
    public PlayerStatisticsPK getPlayerStatisticsPK() {
        return playerStatisticsPK;
    }

    public PlayerStatistics setPlayerStatisticsPK(PlayerStatisticsPK playerStatisticsPK) {
        this.playerStatisticsPK = playerStatisticsPK;
        return this;
    }
}
