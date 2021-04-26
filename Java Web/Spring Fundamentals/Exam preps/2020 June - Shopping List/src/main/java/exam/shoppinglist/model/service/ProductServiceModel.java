package exam.shoppinglist.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ProductServiceModel extends BaseServiceModel{
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryServiceModel category;
}
