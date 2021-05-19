package spring.softunimusicdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;
import spring.softunimusicdb.repository.UserRepository;
import spring.softunimusicdb.service.UserRoleService;
import spring.softunimusicdb.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void seedUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity()
                    .setName("admin")
                    .setPassword(passwordEncoder.encode("admin"))
                    .setRoles(List.of(this.userRoleService.getUserRoleByRole(UserRole.ADMIN),
                            this.userRoleService.getUserRoleByRole(UserRole.USER)));

            UserEntity user = new UserEntity()
                    .setName("user")
                    .setPassword(passwordEncoder.encode("user"))
                    .setRoles(List.of(this.userRoleService.getUserRoleByRole(UserRole.USER)));

            userRepository.saveAll(List.of(admin, user));
        }
    }
}
