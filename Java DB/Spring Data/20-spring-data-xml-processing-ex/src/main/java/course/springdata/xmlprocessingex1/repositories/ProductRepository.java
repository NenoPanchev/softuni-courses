package course.springdata.xmlprocessingex1.repositories;

import course.springdata.xmlprocessingex1.models.entities.Product;
import course.springdata.xmlprocessingex1.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getByName(String name);
    List<Product> findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal low, BigDecimal high);
    Set<Product> findAllBySellerAndBuyerIsNotNull(User seller);
    @Query("SELECT AVG(p.price) FROM Category c " +
            "JOIN c.products p " +
            "WHERE c.id = :id")
    BigDecimal getAvgProductPriceByCategoryId(@Param(value = "id") Long id);

    @Query("SELECT SUM(p.price) FROM Category c " +
            "JOIN c.products p " +
            "WHERE c.id = :id")
    BigDecimal getSumProductPriceByCategoryId(@Param(value = "id") Long id);
}
