package exams.heroes.model.binding;

import exams.heroes.model.entity.Class;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HeroCreateBindingModel {
    private String name;
    private Class aClass;
    private Integer level;

    public HeroCreateBindingModel() {
    }

    @Length(min = 2, message = "Hero name must be more than two characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Min(value = 0, message = "Hero level must be between 0 and 100")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
