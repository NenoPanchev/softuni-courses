package exams.gira.model.view;

import exams.gira.model.entity.ClassificationName;
import exams.gira.model.entity.Progress;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TaskViewModel {
    private String id;
    private String name;
    private String assignedTo;
    private ClassificationName classificationName;
    private LocalDate dueDate;
    private Progress progress;
}
