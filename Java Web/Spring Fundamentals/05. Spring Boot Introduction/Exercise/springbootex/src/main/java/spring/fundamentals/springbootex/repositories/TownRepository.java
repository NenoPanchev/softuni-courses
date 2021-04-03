package spring.fundamentals.springbootex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootex.models.entities.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Town getByName(String name);
}
