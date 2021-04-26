package exam.shoppinglist.model.view;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductViewModel {
    private String id;
    private String name;
    private BigDecimal price;
}
