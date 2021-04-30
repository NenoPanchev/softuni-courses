package exams.heroes.model.service;

import exams.heroes.model.entity.Class;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroServiceModel extends BaseServiceModel {
    private String name;
    private Class aClass;
    private Integer level;
}
