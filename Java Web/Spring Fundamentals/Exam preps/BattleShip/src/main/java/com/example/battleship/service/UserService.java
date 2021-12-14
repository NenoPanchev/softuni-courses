package com.example.battleship.service;

import com.example.battleship.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
    UserServiceModel getPrincipal();
}
