package services.implementations;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.UserRepository;
import services.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
