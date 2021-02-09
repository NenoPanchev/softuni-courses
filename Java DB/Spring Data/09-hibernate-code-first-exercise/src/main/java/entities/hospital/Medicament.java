package entities.hospital;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Medicament extends BaseEntity {
    private String name;

    public Medicament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
