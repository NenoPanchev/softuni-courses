package springdataautomappingex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import springdataautomappingex.domain.dtos.UserDto;
import springdataautomappingex.domain.dtos.UserLoginDto;
import springdataautomappingex.domain.dtos.UserRegisterDto;
import springdataautomappingex.domain.entities.Role;
import springdataautomappingex.domain.entities.User;
import springdataautomappingex.repositories.UserRepository;
import springdataautomappingex.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterDto dto) {
        User user = this.modelMapper.map(dto, User.class);
        user.setRole(this.userRepository.count() == 0 ? Role.ADMIN : Role.USER);

        try {
            this.userRepository.saveAndFlush(user);
            System.out.printf("%s was registered%n", user.getFullName());
        } catch (DataIntegrityViolationException e) {
            System.out.println("That email is taken.");;
        }
    }

    @Override
    public String loginUser(UserLoginDto userLoginDto) {
        User user = this.userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());

        if (user == null) {
            return "Incorrect username / password";
        }
        this.userDto = this.modelMapper.map(user, UserDto.class);
        return String.format("Successfully logged in %s", this.userDto.getFullName());
    }

    @Override
    public String logout() {
        if (this.userDto == null) {
            return "Cannot log out. No user was logged in.";
        }
        String name = this.userDto.getFullName();
        this.userDto = null;
        return String.format("User %s successfully logged out", name);
    }

    @Override
    public boolean isLoggedUserAdmin() {
        if (this.userDto == null || this.userDto.getRole().equals(Role.USER)) {
            return false;
        } else
        return this.userDto.getRole().equals(Role.ADMIN);
    }

    @Override
    public void printOwnedGamesByLoggedInUser() {
        if (this.userDto == null) {
            System.out.println("Only logged in user can look for owned games.");
            return;
        }

        User loggedInUser = this.userRepository.findByEmailAndPassword(this.userDto.getEmail(), this.userDto.getPassword());

        if (loggedInUser.getGames().isEmpty()) {
            System.out.printf("%s does not own any games.%n", loggedInUser.getFullName());
            return;
        }
        loggedInUser.getGames().forEach(game -> System.out.println(game.getTitle()));
    }

    public UserDto getUserDto() {
        return this.userDto;
    }

    @Override
    public User getLoggedUser() {
        return this.userRepository.findByEmailAndPassword(this.userDto.getEmail(), this.userDto.getPassword());
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }


}
