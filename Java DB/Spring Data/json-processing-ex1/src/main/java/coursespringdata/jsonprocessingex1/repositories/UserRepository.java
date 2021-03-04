package coursespringdata.jsonprocessingex1.repositories;

import coursespringdata.jsonprocessingex1.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    User getByFirstNameAndLastNameAndAge(String firstName, String lastName, int age);
    @Query("SELECT u FROM User u " +
            "WHERE u.productsSold.size > 0 " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllByProductsSoldIsNotNullOrderByLastNameAscFirstNameAsc();

    @Query("SELECT u FROM User u " +
            "WHERE u.productsSold.size > 0 " +
            "ORDER BY u.productsSold.size DESC, u.lastName")
    List<User> findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc();
}
