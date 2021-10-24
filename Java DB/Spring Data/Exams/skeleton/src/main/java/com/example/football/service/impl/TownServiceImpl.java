package com.example.football.service.impl;

import com.example.football.constants.GlobalConstants;
import com.example.football.models.dto.json.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
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

import static com.example.football.constants.GlobalConstants.TOWNS_FILE_PATH;


@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Arrays
                .stream(gson.fromJson(new FileReader(TOWNS_FILE_PATH), TownSeedDto[].class))
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && townRepository.findByName(dto.getName()).isEmpty();
                    sb
                            .append(isValid ? String.format("Successfully imported Town %s - %d",
                                    dto.getName(), dto.getPopulation())
                                    : "Invalid Town")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Town.class))
                .forEach(townRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Optional<Town> findByName(String name) {
        return townRepository.findByName(name);
    }
}
