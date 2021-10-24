package web.exams.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.exams.coffeeshop.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);
    @Query("SELECT u FROM User u " +
            "ORDER BY u.orders.size DESC ")
    List<User> findAllByOrderByOrdersDesc();
}
