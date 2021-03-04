package coursespringdata.jsonprocessingex1.services;

import coursespringdata.jsonprocessingex1.models.dtos.CategoryByProductsDto;
import coursespringdata.jsonprocessingex1.models.dtos.CategorySeedDto;
import coursespringdata.jsonprocessingex1.models.entities.Category;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] categorySeedDtos);
    Category getRandomCategory();
    List<Category> getAllCategoriesOrderedByProductCount();
//    List<CategoryByProductsDto> getAllCategoriesByProductCount();
}
