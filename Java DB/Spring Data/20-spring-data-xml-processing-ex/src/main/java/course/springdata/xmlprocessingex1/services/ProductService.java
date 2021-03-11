package course.springdata.xmlprocessingex1.services;

import course.springdata.xmlprocessingex1.models.dtos.ProductSeedDto;
import course.springdata.xmlprocessingex1.models.dtos.view.ProductViewInRangeRootDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(List<ProductSeedDto> dtos);
    ProductViewInRangeRootDto getProductsIn500To1000RangeWithBuyerNullOrderedByPrice();
    BigDecimal getAvgProductPriceByCategoryId(Long id);
    BigDecimal getSumProductPriceByCategoryId(Long id);
}
