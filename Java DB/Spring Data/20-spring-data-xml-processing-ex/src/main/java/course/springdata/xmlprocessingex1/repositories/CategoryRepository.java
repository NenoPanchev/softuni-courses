package course.springdata.xmlprocessingex1.repositories;

import course.springdata.xmlprocessingex1.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    Category getById(Long id);
    @Query("SELECT c FROM Category c " +
            "JOIN c.products p " +
            "GROUP BY c.id " +
            "ORDER BY c.products.size DESC ")
    List<Category> findAllOrderedByCountOfProducts();
}
