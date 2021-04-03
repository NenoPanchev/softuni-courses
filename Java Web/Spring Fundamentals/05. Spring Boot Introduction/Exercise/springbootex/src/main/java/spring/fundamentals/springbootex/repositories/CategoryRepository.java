package spring.fundamentals.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootex.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByName(String name);
}
