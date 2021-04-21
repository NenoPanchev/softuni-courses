package spring.web.exams.andreys.services;

import spring.web.exams.andreys.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
