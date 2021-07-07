package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
    private String name;
    private CompetitionType competitionType;
    private Set<Game> games;

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

    @OneToMany(mappedBy = "competition")
    public Set<Game> getGames() {
        return games;
    }

    public Competition setGames(Set<Game> games) {
        this.games = games;
        return this;
    }
}
