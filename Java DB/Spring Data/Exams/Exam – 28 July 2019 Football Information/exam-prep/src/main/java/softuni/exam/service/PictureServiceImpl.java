package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.dtos.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;


@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public String importPictures() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PictureSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(PICTURES_FILE_PATH, PictureSeedRootDto.class);

        rootDto.getPictures()
                .forEach(dto -> {
                    if (this.validationUtil.isValid(dto)) {
                        if (this.pictureRepository.getByUrl(dto.getUrl()) == null) {
                            this.pictureRepository.saveAndFlush(this.modelMapper.map(dto, Picture.class));
                            sb.append("Successfully imported picture - ").append(dto.getUrl());
                        } else {
                            sb.append("Picture already in DB");
                        }
                    } else {
                        sb.append("Invalid picture");
                    }
                    sb.append(System.lineSeparator());
                });

       return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public Picture getPictureByUrl(String url) {
        return this.pictureRepository.getByUrl(url);
    }
}
