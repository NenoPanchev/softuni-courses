package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.xml.PlaneSeedDto;
import softuni.exam.models.dtos.xml.PlaneSeedRootDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        List<PlaneSeedDto> dtos = this.xmlParser
                .unmarshalFromFile(PLANES_FILE_PATH, PlaneSeedRootDto.class)
                .getPlanes();
        dtos
                .forEach(dto -> {
                    Plane plane = this.planeRepository.getByRegisterNumber(dto.getRegisterNumber());

                    if (this.validationUtil.isValid(dto) && plane == null) {
                        plane = this.modelMapper.map(dto, Plane.class);
                        this.planeRepository.saveAndFlush(plane);
                        sb.append(String.format("Successfully imported Plane %s",
                                dto.getRegisterNumber()));
                    } else {
                        sb.append("Invalid Plane");
                    }
                    sb.append(System.lineSeparator());

                });

        return sb.toString();
    }

    @Override
    public Plane getByRegisterNumber(String registerNumber) {
        return this.planeRepository.getByRegisterNumber(registerNumber);
    }
}
