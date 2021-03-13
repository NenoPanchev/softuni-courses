package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constants.GlobalConstants;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dtos.PictureSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.instagraphlite.constants.GlobalConstants.*;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public Boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson
                .fromJson(new FileReader(PICTURES_FILE_PATH), PictureSeedDto[].class))
                .forEach(dto -> {
                    Picture picture = this.pictureRepository.getByPath(dto.getPath());

                    if (this.validatorUtil.isValid(dto) && picture == null) {
                        this.pictureRepository.saveAndFlush(this.modelMapper.map(dto, Picture.class));
                        sb.append(String.format("Successfully imported Picture, with size %.2f", dto.getSize()));
                    } else {
                        sb.append("Invalid Picture");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();
        this.pictureRepository.findAllBySizeGreaterThanOrderBySize(30000)
                .forEach(picture -> sb.append(String.format("%.2f - %s%n",
                        picture.getSize(), picture.getPath())));

        return sb.toString();
    }

    @Override
    public Picture getByPath(String path) {
        return this.pictureRepository.getByPath(path);
    }
}
