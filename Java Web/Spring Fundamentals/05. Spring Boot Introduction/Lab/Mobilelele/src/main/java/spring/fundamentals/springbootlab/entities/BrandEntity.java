package spring.fundamentals.springbootlab.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "brandEntity", fetch = FetchType.EAGER)
    private Set<ModelEntity> models;

    public BrandEntity() {
    }

    public BrandEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ModelEntity> getModels() {
        return models;
    }

    public void setModels(Set<ModelEntity> models) {
        this.models = models;
    }
}
