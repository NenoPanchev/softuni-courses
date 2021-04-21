package spring.web.exams.andreys.model.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ItemViewModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgUrl;
}
