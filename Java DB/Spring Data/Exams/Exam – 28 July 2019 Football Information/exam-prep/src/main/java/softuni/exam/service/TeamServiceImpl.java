package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.TeamSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
    }


    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        TeamSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(TEAMS_FILE_PATH, TeamSeedRootDto.class);
        rootDto.getTeams()
                .forEach(dto -> {
                    Picture picture = this.pictureService.getPictureByUrl(dto.getPicture().getUrl());
                    if (this.validationUtil.isValid(dto) && picture != null) {
                        if (this.teamRepository.getByName(dto.getName()) == null) {
                            Team team = this.modelMapper.map(dto, Team.class);
                            team.setPicture(picture);
                            this.teamRepository.saveAndFlush(team);
                            sb.append("Successfully imported team - ").append(team.getName());
                        } else {
                            sb.append("Team already in DB");
                        }
                    } else {
                        sb.append("Invalid team");
                    }
                    sb.append(System.lineSeparator());
                });

       return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public Team getTeamByName(String name) {
        return this.teamRepository.getByName(name);
    }

}
