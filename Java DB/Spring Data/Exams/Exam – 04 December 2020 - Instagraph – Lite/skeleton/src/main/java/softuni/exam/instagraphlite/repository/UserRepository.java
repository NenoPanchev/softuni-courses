package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUsername(String username);
    @Query("SELECT u FROM User u " +
            "ORDER BY u.posts.size DESC ")
    List<User> findAllOrderedByPostCountDesc();

    @Query("SELECT p FROM User u " +
            "JOIN u.posts p " +
            "WHERE u.id = :id " +
            "ORDER BY p.picture.size")
    List<Post> getUserPostsOrderedByPostPicSize(@Param("id") Integer userId);
}
