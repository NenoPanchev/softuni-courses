package entity.hospital;

import entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate date;
    private String comments;
    private Patient patient;

    public Visitation() {
    }

    @Column(nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public Visitation setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    public Visitation setComments(String comments) {
        this.comments = comments;
        return this;
    }

    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public Visitation setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }
}
