package spring.fundamentals.springbootlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootlab.entities.OfferEntity;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
