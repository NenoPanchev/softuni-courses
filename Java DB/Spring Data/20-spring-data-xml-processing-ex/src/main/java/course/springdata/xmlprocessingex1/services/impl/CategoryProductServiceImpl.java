package course.springdata.xmlprocessingex1.services.impl;

import course.springdata.xmlprocessingex1.models.dtos.view.CategoryByProductsDto;
import course.springdata.xmlprocessingex1.models.dtos.view.CategoryViewByProductsRootDto;
import course.springdata.xmlprocessingex1.models.entities.Category;
import course.springdata.xmlprocessingex1.services.CategoryProductService;
import course.springdata.xmlprocessingex1.services.CategoryService;
import course.springdata.xmlprocessingex1.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public CategoryProductServiceImpl(CategoryService categoryService, ProductService productService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public List<Category> getAllCategoriesOrderedByProductCount() {
        return this.categoryService.getAllCategoriesOrderedByProductCount();
    }

    @Transactional
    @Override
    public CategoryViewByProductsRootDto getAllCategoriesByProductCount() {
        List<CategoryByProductsDto> dtos = getAllCategoriesOrderedByProductCount().stream()
                .map(category -> {
                    CategoryByProductsDto dto = this.modelMapper.map(category, CategoryByProductsDto.class);
                    dto.setProductsCount(category.getProducts().size());
                    dto.setAveragePrice(this.productService.getAvgProductPriceByCategoryId(category.getId()));
                    dto.setTotalRevenue(this.productService.getSumProductPriceByCategoryId(category.getId()));
                    return dto;
                })
                .collect(Collectors.toList());
        CategoryViewByProductsRootDto rootDto = new CategoryViewByProductsRootDto();
        rootDto.setCategories(dtos);
        return rootDto;
    }
}
