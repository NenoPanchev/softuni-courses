package web.exams.coffeeshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import web.exams.coffeeshop.model.entity.User;
import web.exams.coffeeshop.model.service.UserServiceModel;
import web.exams.coffeeshop.model.view.UserViewModel;
import web.exams.coffeeshop.repository.UserRepository;
import web.exams.coffeeshop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(entity -> modelMapper.map(entity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc() {
        return userRepository.findAllByOrderByOrdersDesc()
                .stream()
                .map(user -> modelMapper.map(user, UserViewModel.class)
                .setCountOfOrders(user.getOrders().size()))
                .collect(Collectors.toList());
    }
}
