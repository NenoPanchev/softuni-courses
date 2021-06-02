package spring.softunimusicdb.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.entities.UserRoleEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;
import spring.softunimusicdb.model.service.UserRegistrationServiceModel;
import spring.softunimusicdb.repository.UserRepository;
import spring.softunimusicdb.service.UserRoleService;
import spring.softunimusicdb.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final MusicDBUserService musicDBUserService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder, ModelMapper modelMapper, MusicDBUserService musicDBUserService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.musicDBUserService = musicDBUserService;
    }


    @Override
    public void seedUsers() {
        if (userRepository.count() == 0) {
            UserEntity admin = new UserEntity()
                    .setUsername("admin")
                    .setEmail("admin@admin.bg")
                    .setFullName("Admin Adminov")
                    .setPassword(passwordEncoder.encode("admin"))
                    .setRoles(List.of(this.userRoleService.getUserRoleByRole(UserRole.ADMIN),
                            this.userRoleService.getUserRoleByRole(UserRole.USER)));

            UserEntity user = new UserEntity()
                    .setUsername("user")
                    .setFullName("User Userov")
                    .setEmail("user@user.bg")
                    .setPassword(passwordEncoder.encode("user"))
                    .setRoles(List.of(this.userRoleService.getUserRoleByRole(UserRole.USER)));

            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {
        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));
        UserRoleEntity userRoleEntity = userRoleService.getUserRoleByRole(UserRole.USER);

        newUser.addRole(userRoleEntity);
        userRepository.saveAndFlush(newUser);

        UserDetails principal = musicDBUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean usernameExists(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("Username is not in database. Please login again."));
    }

    @Override
    public void updateUser(Long id, String username) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(IllegalStateException::new);
        userEntity.setUsername(username);
        userRepository.saveAndFlush(userEntity);
    }
}
