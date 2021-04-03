package spring.fundamentals.springbootlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootlab.entities.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity getByName(String name);
}
