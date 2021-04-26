package exams.gira.service;

import exams.gira.model.entity.ClassificationName;
import exams.gira.model.service.ClassificationServiceModel;

public interface ClassificationService {
    void initClassifications();
    ClassificationServiceModel getClassificationByName(ClassificationName classificationName);
}
