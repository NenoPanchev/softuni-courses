package exam.shoppinglist.service;

import exam.shoppinglist.model.entity.CategoryName;
import exam.shoppinglist.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();
    CategoryServiceModel findByName(CategoryName name);
}
