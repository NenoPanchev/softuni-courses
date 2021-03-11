package course.springdata.xmlprocessingex2.repositories;

import course.springdata.xmlprocessingex2.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c " +
            "ORDER BY c.birthDate ASC, c.youngDriver ASC")
    List<Customer> getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc();

    @Query("SELECT c FROM Customer c " +
            "WHERE c.sales.size > 0")
    List<Customer> getCustomersWithAtLeastOneSale();
}
