package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.domain.dtos.json.PlayerSeedDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidatorUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.PLAYERS_FILE_PATH;


@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final TeamService teamService;
    private final PictureService pictureService;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, TeamService teamService, PictureService pictureService, ValidatorUtil validatorUtil, Gson gson) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.teamService = teamService;
        this.pictureService = pictureService;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }


    @Override
    public String importPlayers() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Arrays
                .stream(gson.fromJson(new FileReader(PLAYERS_FILE_PATH), PlayerSeedDto[].class))
                .filter(dto -> {
                    boolean isValid = validatorUtil.isValid(dto)
                            && pictureService.findByUrl(dto.getPicture().getUrl()).isPresent()
                            && teamService.findByName(dto.getTeam().getName()).isPresent();
                    sb
                            .append(isValid ? String.format("Successfully imported player: %s %s",
                                    dto.getFirstName(), dto.getLastName())
                                    : "Invalid player")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Player.class)
                .setPicture(pictureService.findByUrl(dto.getPicture().getUrl()).get())
                .setTeam(teamService.findByName(dto.getTeam().getName()).get()))
                .forEach(playerRepository::save);


        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();
        playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(new BigDecimal("100000"))
                .forEach(player -> sb.append(String.format("Player name: %s %s%n" +
                        "\tNumber: %d%n" +
                        "\tSalary: %.2f%n" +
                        "\tTeam: %s%n",
                        player.getFirstName(), player.getLastName(), player.getNumber(),
                        player.getSalary(), player.getTeam().getName())));
        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();
        String teamName = "North Hub";
        sb.append(String.format("Team: %s%n", teamName));
        playerRepository
                .findAllByTeamNameOrderById(teamName)
                .forEach(player -> sb
                .append(String.format("\tPlayer name: %s %s - %s%n" +
                        "\tNumber: %d%n",
                        player.getFirstName(), player.getLastName(), player.getPosition(), player.getNumber())));
        return sb.toString().trim();
    }
}
