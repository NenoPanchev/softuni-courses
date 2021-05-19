package spring.softunimusicdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.softunimusicdb.model.entities.UserRoleEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity getByRole(UserRole userRole);
}
