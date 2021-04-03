package spring.fundamentals.springbootlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootlab.entities.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
