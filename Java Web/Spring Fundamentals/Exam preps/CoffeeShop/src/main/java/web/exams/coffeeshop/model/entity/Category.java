package web.exams.coffeeshop.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private CategoryNameEnum name;
    private Integer neededTime;

    public Category() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum category) {
        this.name = category;
        return this;
    }

    @Column(nullable = false)
    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
