package coursespringdata.jsonprocessingex1.services.impl;

import coursespringdata.jsonprocessingex1.models.dtos.CategoryByProductsDto;
import coursespringdata.jsonprocessingex1.models.entities.Category;
import coursespringdata.jsonprocessingex1.models.entities.Product;
import coursespringdata.jsonprocessingex1.services.CategoryProductService;
import coursespringdata.jsonprocessingex1.services.CategoryService;
import coursespringdata.jsonprocessingex1.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.RoundingMode;
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
    public List<CategoryByProductsDto> getAllCategoriesByProductCount() {
        List<CategoryByProductsDto> dtos = getAllCategoriesOrderedByProductCount().stream()
                .map(category -> {
                    CategoryByProductsDto dto = this.modelMapper.map(category, CategoryByProductsDto.class);
                    dto.setCategory(category.getName());
                    dto.setProductsCount(category.getProducts().size());
                    dto.setAveragePrice(this.productService.getAvgProductPriceByCategoryId(category.getId()));
                    dto.setTotalRevenue(this.productService.getSumProductPriceByCategoryId(category.getId()));
                    return dto;
                })
                .collect(Collectors.toList());
        return dtos;
    }
}
