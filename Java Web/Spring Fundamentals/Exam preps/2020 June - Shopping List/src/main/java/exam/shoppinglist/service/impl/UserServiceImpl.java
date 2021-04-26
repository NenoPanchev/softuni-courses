package exam.shoppinglist.service.impl;

import exam.shoppinglist.model.entity.User;
import exam.shoppinglist.model.service.UserServiceModel;
import exam.shoppinglist.repository.UserRepository;
import exam.shoppinglist.service.UserService;
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
        User user = this.modelMapper.map(userServiceModel, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserServiceModel getByUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }


}
