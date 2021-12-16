package com.example.december2021exam.service;

import com.example.december2021exam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
    UserServiceModel getPrincipal();
}
