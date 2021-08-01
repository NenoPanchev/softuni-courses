package com.example.football.service.impl;

import com.example.football.constants.GlobalConstants;
import com.example.football.models.dto.xml.StatSeedRootDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static com.example.football.constants.GlobalConstants.STATS_FILE_PATH;

@Service
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser
                .unmarshalFromFile(STATS_FILE_PATH, StatSeedRootDto.class)
                .getStats()
                .stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && statRepository.findByPassingAndShootingAndEndurance(
                            dto.getPassing(), dto.getShooting(), dto.getEndurance()).isEmpty();
                    sb
                            .append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                                    dto.getShooting(), dto.getPassing(), dto.getEndurance())
                                    : "Invalid Stat")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Stat.class))
                .forEach(statRepository::save);
        return sb.toString().trim();
    }

    @Override
    public Optional<Stat> findByPassingAndShootingAndEndurance(Float passing, Float shooting, Float endurance) {
        return statRepository.findByPassingAndShootingAndEndurance(passing, shooting, endurance);
    }

    @Override
    public Optional<Stat> findById(Long id) {
        return statRepository.findById(id);
    }
}
