package entity.university;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {
    private Float averageGrade;
    private Integer attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "average_grade")
    public Float getAverageGrade() {
        return averageGrade;
    }

    public Student setAverageGrade(Float averageGrade) {
        this.averageGrade = averageGrade;
        return this;
    }

    @Column
    public Integer getAttendance() {
        return attendance;
    }

    public Student setAttendance(Integer attendance) {
        this.attendance = attendance;
        return this;
    }

    @ManyToMany
    @JoinTable(
    joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public Student setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
