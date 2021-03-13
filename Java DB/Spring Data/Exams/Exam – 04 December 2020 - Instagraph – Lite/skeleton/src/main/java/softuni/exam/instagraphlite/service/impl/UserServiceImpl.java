package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constants.GlobalConstants;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.UserSeedDto;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.instagraphlite.constants.GlobalConstants.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, PictureService pictureService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.pictureService = pictureService;
    }


    @Override
    public Boolean аreImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson
                .fromJson(new FileReader(USERS_FILE_PATH), UserSeedDto[].class))
                .forEach(dto -> {
                    User user = this.userRepository.getByUsername(dto.getUsername());
                    Picture picture = this.pictureService.getByPath(dto.getProfilePicture());

                    if (this.validatorUtil.isValid(dto) && user == null
                            && picture != null) {
                        user = this.modelMapper.map(dto, User.class);
                        user.setProfilePicture(picture);
                        this.userRepository.saveAndFlush(user);
                        sb.append(String.format("Successfully imported User: %s", user.getUsername()));
                    } else {
                        sb.append("Invalid User");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        this.userRepository.findAllOrderedByPostCountDesc()
                .forEach( user -> {
                    sb.append(String.format("User: %s%nPost count: %d%n",
                            user.getUsername(), user.getPosts().size()));
                    this.userRepository.getUserPostsOrderedByPostPicSize(user.getId())
                            .forEach(post -> {
                                sb.append("==Post Details:").append(System.lineSeparator());
                                sb.append(String.format("----Caption: %s%n----Picture Size: %.2f%n",
                                        post.getCaption(), post.getPicture().getSize()));
                            });
                });

        return sb.toString();
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.getByUsername(username);
    }
}
