package coursespringdata.jsonprocessingex1.services;

import coursespringdata.jsonprocessingex1.models.dtos.ProductInRangeDto;
import coursespringdata.jsonprocessingex1.models.dtos.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] dtos);
    List<ProductInRangeDto> getProductsIn500To1000RangeWithBuyerNullOrderedByPrice();
    BigDecimal getAvgProductPriceByCategoryId(Long id);
    BigDecimal getSumProductPriceByCategoryId(Long id);
}
