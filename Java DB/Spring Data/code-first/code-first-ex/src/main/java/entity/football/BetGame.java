package entity.football;

import entity.football.composite.BetGamePK;

import javax.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    private BetGamePK betGamePK;
    private ResultPrediction resultPrediction;

    public BetGame() {
    }

    @EmbeddedId
    public BetGamePK getBetGamePK() {
        return betGamePK;
    }

    public BetGame setBetGamePK(BetGamePK betGamePK) {
        this.betGamePK = betGamePK;
        return this;
    }

    @OneToOne
    @JoinColumn(name = "result_prediction", referencedColumnName = "id")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public BetGame setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
        return this;
    }
}
