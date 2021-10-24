package softuni.exam.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{
    private String name;
    private Long population;
    private String guide;

    public Town() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public Long getPopulation() {
        return population;
    }

    public Town setPopulation(Long population) {
        this.population = population;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getGuide() {
        return guide;
    }

    public Town setGuide(String guide) {
        this.guide = guide;
        return this;
    }
}
