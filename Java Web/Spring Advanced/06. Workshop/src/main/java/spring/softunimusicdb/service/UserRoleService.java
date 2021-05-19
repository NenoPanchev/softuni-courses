package spring.softunimusicdb.service;

import spring.softunimusicdb.model.entities.UserRoleEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;

public interface UserRoleService {
    void seedUserRoles();
    UserRoleEntity getUserRoleByRole(UserRole role);
}
