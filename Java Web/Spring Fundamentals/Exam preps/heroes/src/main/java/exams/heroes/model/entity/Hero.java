package exams.heroes.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity{
    private String name;
    private Class aClass;
    private Integer level;

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "class")
    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
