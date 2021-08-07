package course.springdata.xmlprocessingex2.repositories;

import course.springdata.xmlprocessingex2.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier getByNameAndImporter(String name, boolean importer);
    Supplier getById(Long id);
    List<Supplier> findAllByImporterFalse();
}
