package spring.softunimusicdb.service;

import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.service.UserRegistrationServiceModel;

public interface UserService {
    void seedUsers();
    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean usernameExists(String username);
    UserEntity findByUsername(String username);

    void updateUser(Long id, String username);
}
