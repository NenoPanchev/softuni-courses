package entity.football;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {
    private String name;

    public Color() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Color setName(String name) {
        this.name = name;
        return this;
    }
}
