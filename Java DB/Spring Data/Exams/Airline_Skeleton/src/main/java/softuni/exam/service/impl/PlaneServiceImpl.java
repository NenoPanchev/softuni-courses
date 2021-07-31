package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
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
import java.util.Optional;

import static softuni.exam.constants.GlobalConstants.PLANES_FILE_PATH;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public PlaneServiceImpl(PlaneRepository planeRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser
                .unmarshalFromFile(PLANES_FILE_PATH, PlaneSeedRootDto.class)
                .getPlanes()
                .stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && !planeExists(dto.getRegisterNumber());
                    sb
                            .append(isValid ? String.format("Successfully imported Plane %s",
                                    dto.getRegisterNumber())
                                    : "Invalid Plane")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Plane.class))
                .forEach(planeRepository::save);
        return sb.toString().trim();
    }

    @Override
    public boolean planeExists(String registerNumber) {
        return planeRepository.existsByRegisterNumber(registerNumber);
    }

    @Override
    public Optional<Plane> findByRegisterNumber(String registerNumber) {
        return planeRepository.findByRegisterNumber(registerNumber);
    }
}
