package course.springdata.xmlprocessingex1.services;

import course.springdata.xmlprocessingex1.models.dtos.view.CategoryViewByProductsRootDto;
import course.springdata.xmlprocessingex1.models.entities.Category;

import java.util.List;

public interface CategoryProductService {
    List<Category> getAllCategoriesOrderedByProductCount();

    CategoryViewByProductsRootDto getAllCategoriesByProductCount();
}
