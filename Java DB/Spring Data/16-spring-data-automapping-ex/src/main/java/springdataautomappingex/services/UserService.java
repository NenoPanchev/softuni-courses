package springdataautomappingex.services;

import springdataautomappingex.domain.dtos.UserDto;
import springdataautomappingex.domain.dtos.UserLoginDto;
import springdataautomappingex.domain.dtos.UserRegisterDto;
import springdataautomappingex.domain.entities.User;

public interface UserService {
    void registerUser(UserRegisterDto dto);
    String loginUser(UserLoginDto userLoginDto);

    String logout();

    boolean isLoggedUserAdmin();

    void printOwnedGamesByLoggedInUser();

    UserDto getUserDto();

    User getLoggedUser();
    void saveUser(User user);
}
