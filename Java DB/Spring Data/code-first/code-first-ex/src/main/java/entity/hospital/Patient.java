package entity.hospital;

import entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private Byte[] picture;
    private boolean hasInsurance;
    private Set<Medicament> medicaments;

    public Patient() {
    }

    @Column(name = "first_name", length = 50, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public Patient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", length = 60, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public Patient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(length = 200)
    public String getAddress() {
        return address;
    }

    public Patient setAddress(String address) {
        this.address = address;
        return this;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public Patient setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Patient setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Column(columnDefinition = "BLOB")
    public Byte[] getPicture() {
        return picture;
    }

    public Patient setPicture(Byte[] picture) {
        this.picture = picture;
        return this;
    }

    @Column(name = "has_insurance")
    public boolean isHasInsurance() {
        return hasInsurance;
    }

    public Patient setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
        return this;
    }

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"))
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public Patient setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
        return this;
    }
}
