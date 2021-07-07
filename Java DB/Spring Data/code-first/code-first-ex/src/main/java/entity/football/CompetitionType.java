package entity.football;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseEntity {
    private String type;

    public CompetitionType() {
    }

    @Column(nullable = false)
    public String getName() {
        return type;
    }

    public CompetitionType setName(String type) {
        this.type = type;
        return this;
    }
}
