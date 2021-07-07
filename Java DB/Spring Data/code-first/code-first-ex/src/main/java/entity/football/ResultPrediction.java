package entity.football;

import entity.BaseEntity;
import entity.football.enums.Prediction;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {
    private Prediction prediction;

    public ResultPrediction() {
    }

    @Enumerated(EnumType.STRING)
    public Prediction getPrediction() {
        return prediction;
    }

    public ResultPrediction setPrediction(Prediction prediction) {
        this.prediction = prediction;
        return this;
    }
}
