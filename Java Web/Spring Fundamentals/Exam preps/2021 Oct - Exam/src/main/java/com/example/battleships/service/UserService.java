package com.example.battleships.service;

import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
    UserServiceModel getPrincipal();
}
