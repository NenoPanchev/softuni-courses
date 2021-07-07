package entity.football.composite;

import entity.football.Bet;
import entity.football.Game;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BetGamePK implements Serializable {
    private Game game;
    private Bet bet;

    public BetGamePK() {
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    public BetGamePK setGame(Game game) {
        this.game = game;
        return this;
    }

    @ManyToOne
    public Bet getBet() {
        return bet;
    }

    public BetGamePK setBet(Bet bet) {
        this.bet = bet;
        return this;
    }
}
