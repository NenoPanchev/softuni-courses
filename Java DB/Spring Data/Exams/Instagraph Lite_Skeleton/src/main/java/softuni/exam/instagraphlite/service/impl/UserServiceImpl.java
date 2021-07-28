package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constants.GlobalConstants;
import softuni.exam.instagraphlite.models.dtos.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.instagraphlite.constants.GlobalConstants.USERS_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, PictureService pictureService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 2;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(gson
                .fromJson(new FileReader(USERS_FILE_PATH), UserSeedDto[].class))
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && pictureService.pictureExists(dto.getProfilePicture())
                            && !userExistsByUsername(dto.getUsername());
                    sb
                            .append(isValid ? String.format("Successfully imported User: %s",
                                    dto.getUsername())
                                    : "Invalid User")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, User.class)
                .setProfilePicture(pictureService.getPictureByPath(dto.getProfilePicture())))
                .forEach(userRepository::save);
        return sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        userRepository.findAllOrderedByPostsCountDescAndId()
                .forEach(user -> {
                        sb.append(String.format("User: %s%n" +
                        "Post count: %d%n",
                        user.getUsername(), user.getPosts().size()));
                user
                        .getPosts()
                        .stream()
                        .sorted((a, b) -> Double.compare(a.getPicture().getSize(), b.getPicture().getSize()))
                        .forEach(post -> sb.append(String.format("==Post Details:%n" +
                                                        "----Caption: %s%n" +
                                                        "----Picture Size: %.2f%n",
                                post.getCaption(), post.getPicture().getSize())));
                });

        return sb.toString().trim();
    }

    @Override
    public boolean userExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
