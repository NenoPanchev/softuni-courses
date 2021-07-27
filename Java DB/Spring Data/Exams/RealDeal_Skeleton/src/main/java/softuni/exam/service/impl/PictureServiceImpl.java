package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PictureSeedDto;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.PICTURES_FILE_PATH;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CarService carService;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, CarService carService) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files
                .readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        PictureSeedDto[] dtos = gson
                .fromJson(new FileReader(PICTURES_FILE_PATH), PictureSeedDto[].class);

        Arrays.stream(dtos)
                .filter(dto -> {
                    boolean isValid = this.validationUtil.isValid(dto);

                    sb
                            .append(isValid ? String.format("Successfully import picture - %s",
                                    dto.getName())
                                    : "Invalid picture")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto ->  modelMapper.map(dto, Picture.class)
                            .setCar(carService.getCarById(dto.getCar())))
                .forEach(pictureRepository::save);

        return sb.toString().trim();
    }
}
