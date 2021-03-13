package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constants.GlobalConstants;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.xml.PostSeedRootDto;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.instagraphlite.constants.GlobalConstants.*;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PictureService pictureService;
    private final UserService userService;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PictureService pictureService, UserService userService, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.pictureService = pictureService;
        this.userService = userService;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public Boolean аreImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        this.xmlParser
                .unmarshalFromFile(POSTS_FILE_PATH, PostSeedRootDto.class)
                .getPosts()
                .forEach(dto -> {

                    Picture picture = this.pictureService.getByPath(dto.getPicture().getPath());
                    User user = this.userService.getByUsername(dto.getUser().getUsername());

                    if (this.validatorUtil.isValid(dto) && picture != null
                            && user != null) {
                        Post post = this.modelMapper.map(dto, Post.class);
                        post.setPicture(picture);
                        post.setUser(user);
                        this.postRepository.saveAndFlush(post);
                        sb.append(String.format("Successfully imported Post, made by %s",
                                post.getUser().getUsername()));
                    } else {
                        sb.append("Invalid Post");
                    }
                    sb.append(System.lineSeparator());
        });

        return sb.toString();
    }
}
