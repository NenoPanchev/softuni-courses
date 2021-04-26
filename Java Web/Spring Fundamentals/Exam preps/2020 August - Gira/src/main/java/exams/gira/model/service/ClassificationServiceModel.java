package exams.gira.model.service;

import exams.gira.model.entity.ClassificationName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassificationServiceModel extends BaseServiceModel {
    private ClassificationName classificationName;
    private String description;
}
