package spring.softunimusicdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.softunimusicdb.model.entities.LogEntity;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
