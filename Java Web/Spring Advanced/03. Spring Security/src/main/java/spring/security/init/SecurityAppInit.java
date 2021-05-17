package spring.security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.security.model.UserEntity;
import spring.security.model.UserRoleEntity;
import spring.security.model.enums.UserRole;
import spring.security.repository.UserRepository;
import spring.security.repository.UserRoleRepository;

import java.util.List;

@Component
public class SecurityAppInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityAppInit(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0 && userRoleRepository.count() == 0) {


            UserRoleEntity userRole = userRoleRepository.save(new UserRoleEntity().setRole(UserRole.USER));
            UserRoleEntity adminRole = userRoleRepository.save(new UserRoleEntity().setRole(UserRole.ADMIN));

            //simple user
            UserEntity userEntity = new UserEntity();
            userEntity.setName("user");
            userEntity.setPassword(passwordEncoder.encode("user"));
            userEntity.setRoles(List.of(userRole));

            UserEntity admin = new UserEntity();
            admin.setName("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRoles(List.of(adminRole, userRole));

            userRepository.save(userEntity);
            userRepository.save(admin);
        }
    }
}
