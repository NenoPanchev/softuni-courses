package spring.hateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hateoas.model.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
