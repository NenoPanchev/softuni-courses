package entity.football;

import entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
    private String name;
    private CompetitionType competitionType;

    public Competition() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Competition setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "competition_type", referencedColumnName = "id")
    public CompetitionType getType() {
        return competitionType;
    }

    public Competition setType(CompetitionType competitionType) {
        this.competitionType = competitionType;
        return this;
    }
}
