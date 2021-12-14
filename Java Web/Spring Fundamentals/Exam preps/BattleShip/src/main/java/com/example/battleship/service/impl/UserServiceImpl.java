package com.example.battleship.service.impl;

import com.example.battleship.model.entity.User;
import com.example.battleship.model.service.UserServiceModel;
import com.example.battleship.repository.UserRepository;
import com.example.battleship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(entity -> modelMapper.map(entity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserServiceModel getPrincipal() {
        UserServiceModel principal = (UserServiceModel) httpSession.getAttribute("user");
        User user = modelMapper.map(
                findByUsernameAndPassword(principal.getUsername(), principal.getPassword()), User.class);
        return modelMapper.map(user, UserServiceModel.class);
    }
}
