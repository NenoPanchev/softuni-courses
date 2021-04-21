package spring.web.exams.andreys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.web.exams.andreys.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
