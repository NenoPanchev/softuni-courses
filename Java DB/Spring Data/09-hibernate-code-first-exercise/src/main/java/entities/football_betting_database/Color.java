package entities.football_betting_database;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {
    private String name;

    public Color() {
    }

    @Column(name = "name", length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
