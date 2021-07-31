package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.dtos.xml.PictureSeedDto;
import softuni.exam.domain.dtos.xml.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.constants.GlobalConstants.PICTURES_FILE_PATH;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidatorUtil validatorUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser
                .unmarshalFromFile(PICTURES_FILE_PATH, PictureSeedRootDto.class)
                .getPictures()
                .stream()
                .filter(dto -> {
                    boolean isValid = validatorUtil.isValid(dto)
                            && findByUrl(dto.getUrl()).isEmpty();
                    sb
                            .append(isValid ? String.format("Successfully imported picture - %s",
                                    dto.getUrl())
                                    : "Invalid picture")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Picture.class))
                .forEach(pictureRepository::save);
        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public Optional<Picture> findByUrl(String url) {
        return pictureRepository.findByUrl(url);
    }

}
