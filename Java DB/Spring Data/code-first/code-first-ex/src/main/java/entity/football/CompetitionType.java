package entity.football;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseEntity {
    private String name;

    public CompetitionType() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public CompetitionType setName(String name) {
        this.name = name;
        return this;
    }
}
