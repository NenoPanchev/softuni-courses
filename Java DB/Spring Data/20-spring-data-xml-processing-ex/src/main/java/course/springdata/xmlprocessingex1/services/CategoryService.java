package course.springdata.xmlprocessingex1.services;

import course.springdata.xmlprocessingex1.models.dtos.CategorySeedDto;
import course.springdata.xmlprocessingex1.models.entities.Category;

import java.util.List;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categorySeedDtos);
    Category getRandomCategory();
    List<Category> getAllCategoriesOrderedByProductCount();
//    List<CategoryByProductsDto> getAllCategoriesByProductCount();
}
