package entities.football_betting_database;

import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {

    private BigDecimal betMoney;
    private LocalDateTime timeOfBet;
    private User user;

    public Bet() {
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time")
    public LocalDateTime getTimeOfBet() {
        return timeOfBet;
    }

    public void setTimeOfBet(LocalDateTime timeOfBet) {
        this.timeOfBet = timeOfBet;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
