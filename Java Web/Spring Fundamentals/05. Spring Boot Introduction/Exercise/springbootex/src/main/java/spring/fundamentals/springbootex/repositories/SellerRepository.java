package spring.fundamentals.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootex.models.entities.Seller;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller getByFirstNameAndLastName(String firstName, String lastName);
    List<Seller> findAllByShopName(String shopName);
}
