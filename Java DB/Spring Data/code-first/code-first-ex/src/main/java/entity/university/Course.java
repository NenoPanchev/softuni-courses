package entity.university;

import entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer credits;
    private Set<Student> students;
    private Teacher teacher;

    public Course() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }

    public Course setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Column(name = "end_date")
    public LocalDate getEndDate() {
        return endDate;
    }

    public Course setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    @Column
    public Integer getCredits() {
        return credits;
    }

    public Course setCredits(Integer credits) {
        this.credits = credits;
        return this;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Student> getStudents() {
        return students;
    }

    public Course setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    @ManyToOne
    public Teacher getTeacher() {
        return teacher;
    }

    public Course setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }
}
