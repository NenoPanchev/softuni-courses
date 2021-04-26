package exams.gira.service.impl;

import exams.gira.model.binding.UserRegisterBindingModel;
import exams.gira.model.entity.User;
import exams.gira.model.service.UserServiceModel;
import exams.gira.repository.UserRepository;
import exams.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        this.userRepository.saveAndFlush(this.modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel getByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email,password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class ))
                .orElse(null);
    }
}
