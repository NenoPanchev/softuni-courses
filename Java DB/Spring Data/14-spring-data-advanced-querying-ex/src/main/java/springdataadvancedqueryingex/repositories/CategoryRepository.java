package springdataadvancedqueryingex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdataadvancedqueryingex.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
