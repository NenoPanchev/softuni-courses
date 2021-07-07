package entity.football;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {
    private BigDecimal betMoney;
    private LocalDateTime dateTime;
    private User user;

    public Bet() {
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public Bet setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
        return this;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Bet setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Bet setUser(User user) {
        this.user = user;
        return this;
    }
}
