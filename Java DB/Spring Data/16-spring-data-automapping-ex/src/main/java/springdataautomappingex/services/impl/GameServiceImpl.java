package springdataautomappingex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springdataautomappingex.domain.dtos.GameAddDto;
import springdataautomappingex.domain.dtos.GameEditDto;
import springdataautomappingex.domain.entities.Game;
import springdataautomappingex.repositories.GameRepository;
import springdataautomappingex.services.GameService;
import springdataautomappingex.services.UserService;
import springdataautomappingex.utils.ValidationUtil;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Game game = this.modelMapper.map(gameAddDto, Game.class);
        if (this.userService.isLoggedUserAdmin()) {
            this.gameRepository.saveAndFlush(game);
            System.out.printf("Added %s%n", game.getTitle());
        } else {
            System.out.println("Only admin can add games.");
        }
    }

    @Override
    public void editGame(String[] data) {
        if (!this.userService.isLoggedUserAdmin()) {
            System.out.println("Only admin cad edit games.");
            return;
        }

        Optional<Game> game = this.gameRepository.findById(Long.parseLong(data[1]));
        if (!game.isPresent()) {
            System.out.println("Incorrect game ID.");
            return;
        }

        GameEditDto gameEditDto = this.modelMapper.map(game.get(), GameEditDto.class);

        Arrays.stream(data)
                .skip(2)
                .forEach(s -> {
                    String[] tokens = s.split("=");

                    switch (tokens[0]) {
                        case "title":
                            gameEditDto.setTitle(tokens[1]);
                            break;
                        case "price":
                            gameEditDto.setPrice(new BigDecimal(tokens[1]));
                            break;
                        case "size":
                            gameEditDto.setSize(Double.parseDouble(tokens[1]));
                            break;
                        case "trailer":
                            gameEditDto.setTrailer(tokens[1]);
                            break;
                        case "thumbnail":
                            gameEditDto.setImageThumbnailURL(tokens[1]);
                            break;
                        case "description":
                            gameEditDto.setDescription(tokens[1]);
                            break;
                        case "releaseDate":
                            gameEditDto.setReleaseDate(LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                            break;
                        default:
                            System.out.println("Incorrect values");
                            break;
                    }
                });
        if (this.validationUtil.isValid(gameEditDto)) {
            Game game1 = this.modelMapper.map(gameEditDto, Game.class);
            this.gameRepository.saveAndFlush(game1);
            System.out.printf("%s edited%n", game1.getTitle());
        } else {
            this.validationUtil.getViolations(gameEditDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }

    @Override
    public void deleteGame(long id) {
        if (!this.userService.isLoggedUserAdmin()) {
            System.out.println("Only admin cad delete games.");
            return;
        }
        Optional<Game> game = this.gameRepository.findById(id);
        if (!game.isPresent()) {
            System.out.println("Incorrect game ID.");
            return;
        }
        String gameName = game.get().getTitle();
        this.gameRepository.deleteById(id);
        System.out.printf("%s deleted%n", gameName);
    }

    @Override
    public void printAllGames() {
        this.gameRepository.findAll().forEach(game -> System.out.printf("%s %.2f%n", game.getTitle(), game.getPrice()));
    }

    @Override
    public void printGameByTitle(String title) {
        System.out.println(this.gameRepository.findByTitle(title));
    }

    @Override
    public Game getGameByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }
}
