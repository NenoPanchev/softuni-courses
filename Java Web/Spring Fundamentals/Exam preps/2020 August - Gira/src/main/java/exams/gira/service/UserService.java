package exams.gira.service;

import exams.gira.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);
    UserServiceModel getByEmailAndPassword(String email, String password);
}
