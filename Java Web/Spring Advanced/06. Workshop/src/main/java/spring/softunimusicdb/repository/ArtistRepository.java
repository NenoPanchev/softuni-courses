package spring.softunimusicdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.softunimusicdb.model.entities.ArtistEntity;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
}
