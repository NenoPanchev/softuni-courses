package spring.web.exams.andreys.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.web.exams.andreys.model.entity.CategoryName;

@Data
@NoArgsConstructor
public class CategoryServiceModel extends BaseServiceModel {
    private CategoryName name;
    private String description;
}
