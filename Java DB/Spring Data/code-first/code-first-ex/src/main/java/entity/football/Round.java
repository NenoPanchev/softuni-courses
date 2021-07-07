package entity.football;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rounds")
public class Round extends BaseEntity {
    private String name;

    public Round() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Round setName(String name) {
        this.name = name;
        return this;
    }
}
