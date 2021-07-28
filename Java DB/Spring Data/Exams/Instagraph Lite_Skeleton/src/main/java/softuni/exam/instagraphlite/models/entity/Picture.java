package softuni.exam.instagraphlite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String path;
    private Double size;

    public Picture() {
    }

    @Column(unique = true, nullable = false)
    public String getPath() {
        return path;
    }

    public Picture setPath(String path) {
        this.path = path;
        return this;
    }

    @Column(nullable = false)
    public Double getSize() {
        return size;
    }

    public Picture setSize(Double size) {
        this.size = size;
        return this;
    }
}
