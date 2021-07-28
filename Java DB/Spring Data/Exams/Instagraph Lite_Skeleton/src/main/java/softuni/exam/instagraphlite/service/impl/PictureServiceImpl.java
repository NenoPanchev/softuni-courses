package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constants.GlobalConstants;
import softuni.exam.instagraphlite.models.dtos.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.instagraphlite.constants.GlobalConstants.PICTURES_FILE_PATH;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays
                .stream(gson.fromJson(new FileReader(PICTURES_FILE_PATH), PictureSeedDto[].class))
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto) && !pictureExists(dto.getPath());
                    sb
                            .append(isValid ? String.format("Successfully imported Picture, with size %.2f",
                                    dto.getSize())
                                    : "Invalid Picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Picture.class))
                .forEach(pictureRepository::save);


        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();
        pictureRepository.findAllBySizeGreaterThanOrderBySize(30000.)
                .forEach(pic -> sb
                .append(String.format("%.2f - %s%n",
                        pic.getSize(), pic.getPath())));
        return sb.toString().trim();
    }

    @Override
    public boolean pictureExists(String path) {
        return pictureRepository.existsByPath(path);
    }

    @Override
    public Picture getPictureByPath(String path) {
        return pictureRepository.getByPath(path);
    }

}
