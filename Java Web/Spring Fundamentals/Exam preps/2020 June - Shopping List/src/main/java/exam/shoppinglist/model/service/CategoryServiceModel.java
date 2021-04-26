package exam.shoppinglist.model.service;

import exam.shoppinglist.model.entity.CategoryName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryServiceModel extends BaseServiceModel{
    private CategoryName name;
    private String description;
}
