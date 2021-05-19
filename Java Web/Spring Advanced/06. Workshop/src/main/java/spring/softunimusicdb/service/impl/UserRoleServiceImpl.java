package spring.softunimusicdb.service.impl;

import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.entities.UserRoleEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;
import spring.softunimusicdb.repository.UserRoleRepository;
import spring.softunimusicdb.service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void seedUserRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);

            this.userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public UserRoleEntity getUserRoleByRole(UserRole role) {
        return this.userRoleRepository.getByRole(role);
    }
}
