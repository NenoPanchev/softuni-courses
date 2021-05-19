package spring.hateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hateoas.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
