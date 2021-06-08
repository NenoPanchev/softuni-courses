package spring.softunimusicdb.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.entities.UserRoleEntity;
import spring.softunimusicdb.model.entities.enums.UserRole;
import spring.softunimusicdb.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class MusicDBUserServiceTest {
    private MusicDBUserService serviceToTest;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    public void setUp() {
        serviceToTest = new MusicDBUserService(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class, () -> {
                    serviceToTest.loadUserByUsername("user_does_not_exist");
                }
        );
    }

    @Test
    void testExistingUser() {
        // prepare data
        UserRoleEntity roleUser = new UserRoleEntity().setRole(UserRole.USER);
        UserRoleEntity roleAdmin = new UserRoleEntity().setRole(UserRole.ADMIN);
        UserEntity userEntity = new UserEntity()
                .setUsername("gosho")
                .setPassword("123")
                .setRoles(List.of(roleUser, roleAdmin));

        // configure mocks
        Mockito.when(mockUserRepository.findByUsername("gosho"))
                .thenReturn(Optional.of(userEntity));

        // test
        UserDetails userDetails = serviceToTest.loadUserByUsername("gosho");

        Assertions.assertEquals(userEntity.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(2, userDetails.getAuthorities().size());

        List<String> authorities = userDetails
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Assertions.assertTrue(authorities.contains("ROLE_ADMIN"));
        Assertions.assertTrue(authorities.contains("ROLE_USER"));
    }
}
