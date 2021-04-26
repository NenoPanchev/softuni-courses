package exams.gira.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{
    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }

    public String getName() {
        return name;
    }

    @Column(unique = true, nullable = false)
    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
