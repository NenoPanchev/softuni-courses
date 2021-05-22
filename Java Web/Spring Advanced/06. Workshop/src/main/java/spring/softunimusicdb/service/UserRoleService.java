package spring.softunimusicdb.service;

import spring.softunimusicdb.model.entities.UserRoleEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;

import java.util.Optional;

public interface UserRoleService {
    void seedUserRoles();
    UserRoleEntity getUserRoleByRole(UserRole role);

}
