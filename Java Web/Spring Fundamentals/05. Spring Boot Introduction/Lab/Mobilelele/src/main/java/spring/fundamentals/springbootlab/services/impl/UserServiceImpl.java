package spring.fundamentals.springbootlab.services.impl;

import org.springframework.stereotype.Service;
import spring.fundamentals.springbootlab.repositories.UserRepository;
import spring.fundamentals.springbootlab.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
