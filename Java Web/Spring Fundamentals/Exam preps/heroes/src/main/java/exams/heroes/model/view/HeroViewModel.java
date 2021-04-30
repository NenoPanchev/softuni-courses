package exams.heroes.model.view;

import exams.heroes.model.entity.Class;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeroViewModel {
    private String id;
    private String name;
    private Class aClass;
    private Integer level;
    private String imgUrl;
}
