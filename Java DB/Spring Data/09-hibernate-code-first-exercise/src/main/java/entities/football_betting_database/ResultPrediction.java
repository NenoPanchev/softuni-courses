package entities.football_betting_database;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {
    private Prediction prediction;

    public ResultPrediction() {
    }

    @Column(name = "prediction", nullable = false)
    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }
}
