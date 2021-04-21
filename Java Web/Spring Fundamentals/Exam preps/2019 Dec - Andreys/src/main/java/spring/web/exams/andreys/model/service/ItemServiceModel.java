package spring.web.exams.andreys.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.web.exams.andreys.model.entity.Gender;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ItemServiceModel extends BaseServiceModel {
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryServiceModel category;
    private Gender gender;
}
