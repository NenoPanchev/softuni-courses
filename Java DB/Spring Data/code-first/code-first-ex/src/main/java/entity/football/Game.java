package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public Game() {
    }

    @ManyToOne
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public Game setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public Game setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    @Column(name = "home_team_goals")
    public Short getHomeGoals() {
        return homeGoals;
    }

    public Game setHomeGoals(Short homeGoals) {
        this.homeGoals = homeGoals;
        return this;
    }

    @Column(name = "away_team_goals")
    public Short getAwayGoals() {
        return awayGoals;
    }

    public Game setAwayGoals(Short awayGoals) {
        this.awayGoals = awayGoals;
        return this;
    }

    @Column(name = "date_time")
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

}
