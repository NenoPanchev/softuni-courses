package exams.heroes.service;

import exams.heroes.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);
    UserServiceModel getByUsernameAndPassword(String username, String password);
}
