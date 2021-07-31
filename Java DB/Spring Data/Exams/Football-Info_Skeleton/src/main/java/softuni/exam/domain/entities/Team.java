package softuni.exam.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team  extends BaseEntity{
    private String name;
    private Picture picture;

    public Team() {
    }

    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Picture getPicture() {
        return picture;
    }

    public Team setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
