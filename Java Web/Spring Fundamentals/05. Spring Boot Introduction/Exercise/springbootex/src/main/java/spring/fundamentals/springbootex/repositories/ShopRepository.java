package spring.fundamentals.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootex.models.entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop getByAddress(String address);
    Shop getByName(String name);
}
