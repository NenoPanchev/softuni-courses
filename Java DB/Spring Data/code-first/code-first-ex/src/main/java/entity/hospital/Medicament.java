package entity.hospital;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {
    private String name;
    private Set<Patient> patients;

    public Medicament() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Medicament setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToMany(mappedBy = "medicaments")
    public Set<Patient> getPatients() {
        return patients;
    }

    public Medicament setPatients(Set<Patient> patients) {
        this.patients = patients;
        return this;
    }
}
