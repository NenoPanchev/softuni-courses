package exams.heroes.repository;

import exams.heroes.model.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {
    @Query("SELECT h FROM Hero h " +
            "ORDER BY h.level DESC ")
    List<Hero> findAllOrderByLevelDesc();
}
