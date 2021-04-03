package spring.fundamentals.springbootlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.fundamentals.springbootlab.entities.UserRoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<UserRoleEntity, Long> {
}
