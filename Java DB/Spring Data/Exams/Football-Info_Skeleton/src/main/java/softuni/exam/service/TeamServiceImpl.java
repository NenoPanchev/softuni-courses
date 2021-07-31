package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.dtos.xml.TeamSeedRootDto;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.constants.GlobalConstants.TEAMS_FILE_PATH;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final PictureService pictureService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public TeamServiceImpl(TeamRepository teamRepository, PictureService pictureService, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.teamRepository = teamRepository;
        this.pictureService = pictureService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser
                .unmarshalFromFile(TEAMS_FILE_PATH, TeamSeedRootDto.class)
                .getTeams()
                .stream()
                .filter(dto -> {
                    boolean isValid = validatorUtil.isValid(dto)
                            && pictureService.findByUrl(dto.getPicture().getUrl()).isPresent();
                    sb
                            .append(isValid ? String.format("Successfully imported - %s", dto.getName())
                                    : "Invalid team")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Team.class)
                .setPicture(pictureService.findByUrl(dto.getPicture().getUrl()).get()))
                .forEach(teamRepository::save);
        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }
}
