package com.example.football.service.impl;

import com.example.football.constants.GlobalConstants;
import com.example.football.models.dto.xml.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static com.example.football.constants.GlobalConstants.PLAYERS_FILE_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TownService townService;
    private final StatService statService;
    private final TeamService teamService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public PlayerServiceImpl(PlayerRepository playerRepository, TownService townService, StatService statService, TeamService teamService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.playerRepository = playerRepository;
        this.townService = townService;
        this.statService = statService;
        this.teamService = teamService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser.unmarshalFromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class)
                .getPlayers()
                .stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && !playerRepository.existsByEmail(dto.getEmail())
                            && townService.findByName(dto.getTown().getName()).isPresent()
                            && teamService.findByName(dto.getTeam().getName()).isPresent()
                            && statService.findById(dto.getStat().getId()).isPresent();

                    sb
                            .append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    dto.getFirstName(), dto.getLastName(), dto.getPosition().name())
                                    : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Player.class)
                .setTown(townService.findByName(dto.getTown().getName()).get())
                .setTeam(teamService.findByName(dto.getTeam().getName()).get())
                .setStat(statService.findById(dto.getStat().getId()).get()))
                .forEach(playerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        playerRepository.findAllByBirthDateBetweenOrderByShootingDescPassingDescEnduranceDescLastName(
                LocalDate.of(1995, 1, 1), LocalDate.of(2003, 1, 1))
                .forEach(player -> sb
                .append(String.format("Player - %s %s%n" +
                        "\tPosition - %s%n" +
                        "\tTeam - %s%n" +
                        "\tStadium - %s%n",
                        player.getFirstName(), player.getLastName(), player.getPosition().name(),
                        player.getTeam().getName(), player.getTeam().getStadiumName())));
        return sb.toString().trim();
    }

    @Override
    public boolean existByEmail(String email) {
        return playerRepository.existsByEmail(email);
    }
}
