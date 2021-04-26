package exams.gira.model.service;

import exams.gira.model.entity.Classification;
import exams.gira.model.entity.Progress;
import exams.gira.model.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TaskServiceModel extends BaseServiceModel{
    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private ClassificationServiceModel classification;
    private UserServiceModel user;
}
