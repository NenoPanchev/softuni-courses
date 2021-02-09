package entities.hospital;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Diagnose extends BaseEntity {
    private String name;
    private String comments;

    public Diagnose() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
