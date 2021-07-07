package entity.hospital;

import entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private String name;
    private String comments;
    private Patient patient;

    public Diagnose() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Diagnose setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public Diagnose setComments(String comments) {
        this.comments = comments;
        return this;
    }

    @OneToOne
    public Patient getPatient() {
        return patient;
    }

    public Diagnose setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }
}
