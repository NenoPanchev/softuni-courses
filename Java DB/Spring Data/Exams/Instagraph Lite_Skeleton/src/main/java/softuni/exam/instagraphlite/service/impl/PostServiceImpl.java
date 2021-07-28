package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constants.GlobalConstants;
import softuni.exam.instagraphlite.models.dtos.xml.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.instagraphlite.constants.GlobalConstants.POSTS_FILE_PATH;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PictureService pictureService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public PostServiceImpl(PostRepository postRepository, PictureService pictureService, UserService userService, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.postRepository = postRepository;
        this.pictureService = pictureService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser
                .unmarshalFromFile(POSTS_FILE_PATH, PostSeedRootDto.class)
                .getPosts()
                .stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && userService.userExistsByUsername(dto.getUser().getUsername())
                            && pictureService.pictureExists(dto.getPicture().getPath());
                    sb
                            .append(isValid ? String.format("Successfully imported Post, made by %s",
                                    dto.getUser().getUsername())
                                    : "Invalid Post")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Post.class)
                .setPicture(pictureService.getPictureByPath(dto.getPicture().getPath()))
                .setUser(userService.getUserByUsername(dto.getUser().getUsername())))
                .forEach(postRepository::save);
        return sb.toString().trim();
    }
}
