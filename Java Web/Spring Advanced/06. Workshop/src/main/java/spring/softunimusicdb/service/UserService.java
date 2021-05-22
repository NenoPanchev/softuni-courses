package spring.softunimusicdb.service;

import spring.softunimusicdb.model.service.UserRegistrationServiceModel;

public interface UserService {
    void seedUsers();
    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean usernameExists(String username);
}
