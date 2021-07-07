package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    private Team homeTeam;
    private Team awayTeam;
    private Short homeGoals;
    private Short awayGoals;
    private LocalDateTime dateTime;
    private Float homeTeamWinBetRate;
    private Float awayTeamWinBetRate;
    private Float drawGameBetRate;
    private Round round;
    private Competition competition;
    private Set<Player> players;

    public Game() {
    }

    @ManyToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Game setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "away_team_id", referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public Game setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    @Column(name = "home_goals")
    public Short getHomeGoals() {
        return homeGoals;
    }

    public Game setHomeGoals(Short homeGoals) {
        this.homeGoals = homeGoals;
        return this;
    }

    @Column(name = "away_goals")
    public Short getAwayGoals() {
        return awayGoals;
    }

    public Game setAwayGoals(Short awayGoals) {
        this.awayGoals = awayGoals;
        return this;
    }

    @Column(name = "date_and_time_of_game")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Game setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @Column(name = "home_team_win_bet_rate")
    public Float getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public Game setHomeTeamWinBetRate(Float homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
        return this;
    }

    @Column(name = "away_team_win_bet_rate")
    public Float getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public Game setAwayTeamWinBetRate(Float awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
        return this;
    }

    @Column(name = "draw_game_bet_rate")
    public Float getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public Game setDrawGameBetRate(Float drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
        return this;
    }

    @ManyToOne
    public Round getRound() {
        return round;
    }

    public Game setRound(Round round) {
        this.round = round;
        return this;
    }

    @ManyToOne
    public Competition getCompetition() {
        return competition;
    }

    public Game setCompetition(Competition competition) {
        this.competition = competition;
        return this;
    }

    @ManyToMany(mappedBy = "games")
    public Set<Player> getPlayers() {
        return players;
    }

    public Game setPlayers(Set<Player> players) {
        this.players = players;
        return this;
    }
}
