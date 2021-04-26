package exam.shoppinglist.service;

import exam.shoppinglist.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);
    UserServiceModel getByUsernameAndPassword(String username, String password);
}
