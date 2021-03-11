package course.springdata.xmlprocessingex2.repositories;

import course.springdata.xmlprocessingex2.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    Part getById(Long id);
}
