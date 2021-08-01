package com.example.football.service.impl;

import com.example.football.constants.GlobalConstants;
import com.example.football.models.dto.json.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import static com.example.football.constants.GlobalConstants.TEAMS_FILE_PATH;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TeamServiceImpl(TeamRepository teamRepository, TownService townService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Arrays
                .stream(gson.fromJson(new FileReader(TEAMS_FILE_PATH), TeamSeedDto[].class))
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && teamRepository.findByName(dto.getName()).isEmpty()
                            && townService.findByName(dto.getTownName()).isPresent();
                    sb
                            .append(isValid ? String.format("Successfully imported Team %s - %d",
                                    dto.getName(), dto.getFanBase())
                                    : "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Team.class)
                .setTown(townService.findByName(dto.getTownName()).get()))
                .forEach(teamRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }
}
