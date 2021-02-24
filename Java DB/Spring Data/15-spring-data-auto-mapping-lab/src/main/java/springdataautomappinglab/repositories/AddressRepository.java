package springdataautomappinglab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdataautomappinglab.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
