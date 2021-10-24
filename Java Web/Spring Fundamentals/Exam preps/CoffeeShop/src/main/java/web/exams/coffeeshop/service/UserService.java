package web.exams.coffeeshop.service;

import web.exams.coffeeshop.model.entity.User;
import web.exams.coffeeshop.model.service.UserServiceModel;
import web.exams.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc();
}
