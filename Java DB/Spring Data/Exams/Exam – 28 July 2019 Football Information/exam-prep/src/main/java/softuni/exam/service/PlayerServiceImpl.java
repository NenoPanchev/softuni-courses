package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PlayerSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidationUtil;


import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.*;


@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final PictureService pictureService;
    private final TeamService teamService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, PictureService pictureService, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.pictureService = pictureService;
        this.teamService = teamService;
    }

    @Override
    public String importPlayers() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        PlayerSeedDto[] dtos = this.gson.fromJson(new FileReader(PLAYERS_FILE_PATH), PlayerSeedDto[].class);

        Arrays.stream(dtos)
                .forEach(dto -> {
                    Picture playerPicture = this.pictureService.getPictureByUrl(dto.getPicture().getUrl());
                    Team team = this.teamService.getTeamByName(dto.getTeam().getName());
                    Picture teamPicture = this.pictureService.getPictureByUrl(dto.getTeam().getPicture().getUrl());

                    if (this.validationUtil.isValid(dto) && playerPicture != null
                    && team != null && teamPicture != null) {
                        if (this.playerRepository.getByFirstNameAndLastName(dto.getFirstName(), dto.getLastName()) == null) {
                            Player player = this.modelMapper.map(dto, Player.class);
                            team.setPicture(teamPicture);
                            player.setPicture(playerPicture);
                            player.setTeam(team);
                            this.playerRepository.saveAndFlush(player);
                            sb.append(String.format("Successfully imported player - %s %s", player.getFirstName(), player.getLastName()));
                        } else {
                            sb.append("Player already in DB");
                        }
                    } else {
                        sb.append("Invalid player");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();
        this.playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000))
                .forEach(player -> sb.append(String.format("Player name: %s %s%n" +
                        "\tNumber: %d%n" +
                        "\tSalary: %s%n" +
                        "\tTeam: %s%n",
                        player.getFirstName(), player.getLastName(),
                        player.getNumber(),
                        player.getSalary(),
                        player.getTeam().getName())));

       return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder("Team: North Hub");
        sb.append(System.lineSeparator());
        this.playerRepository.findAllByTeamName("North Hub")
                .forEach(player -> sb.append(String.format("\tPlayer name: %s %s - %s%n\tNumber: %d%n",
                        player.getFirstName(), player.getLastName(), player.getPosition(), player.getNumber())));

        return sb.toString();
    }


}
