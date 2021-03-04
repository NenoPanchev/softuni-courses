package coursespringdata.jsonprocessingex1.services;

import coursespringdata.jsonprocessingex1.models.dtos.CategoryByProductsDto;
import coursespringdata.jsonprocessingex1.models.entities.Category;

import java.util.List;

public interface CategoryProductService {
    List<Category> getAllCategoriesOrderedByProductCount();

    List<CategoryByProductsDto> getAllCategoriesByProductCount();
}
