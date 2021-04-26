package exam.shoppinglist.repository;

import exam.shoppinglist.model.entity.Category;
import exam.shoppinglist.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByCategory(Category category);
}
