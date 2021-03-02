package springdataautomappingex.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdataautomappingex.domain.dtos.GameAddDto;
import springdataautomappingex.domain.dtos.UserLoginDto;
import springdataautomappingex.domain.dtos.UserRegisterDto;
import springdataautomappingex.services.GameService;
import springdataautomappingex.services.OrderService;
import springdataautomappingex.services.UserService;
import springdataautomappingex.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;
    private final BufferedReader bufferedReader;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final OrderService orderService;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService, BufferedReader bufferedReader, ModelMapper modelMapper, ValidationUtil validationUtil, OrderService orderService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = bufferedReader;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello, fellow student :)");

        while (true) {
            System.out.println("Enter command:");
            String[] input = bufferedReader.readLine().split("\\|");

            switch (input[0]) {
                case "RegisterUser":
                    if (!input[2].equals(input[3])) {
                        System.out.println("Confirmation password doesn't match");
                        break;
                    }

                    UserRegisterDto dto = new UserRegisterDto(input[1],
                            input[2], input[4]);

                    if (this.validationUtil.isValid(dto)) {
                        this.userService.registerUser(dto);
                    } else {
                        this.validationUtil.getViolations(dto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;

                case "LoginUser":
                    UserLoginDto userLoginDto = new UserLoginDto(input[1], input[2]);
                    System.out.println(this.userService.loginUser(userLoginDto));
                    break;

                case "Logout":
                    System.out.println(this.userService.logout());
                    break;

                case "AddGame":
                    GameAddDto gameAddDto = new GameAddDto(input[1], new BigDecimal(input[2]), Double.parseDouble(input[3]),
                            input[4], input[5], input[6], LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));

                    if (this.validationUtil.isValid(gameAddDto)) {
                        this.gameService.addGame(gameAddDto);
                        break;
                    } else {
                        this.validationUtil.getViolations(gameAddDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;

                case "EditGame":
                    this.gameService.editGame(input);
                    break;

                case "DeleteGame":
                    this.gameService.deleteGame(Long.parseLong(input[1]));
                    break;

                case "AllGames":
                    this.gameService.printAllGames();
                    break;

                case "DetailGame":
                    this.gameService.printGameByTitle(input[1]);
                    break;

                case "OwnedGames":
                    this.userService.printOwnedGamesByLoggedInUser();
                    break;

                case "AddItem":
                    this.orderService.addItem(input[1]);
                    break;

                case "RemoveItem":
                    if (this.orderService.removeItem(input[1])) {
                        System.out.printf("%s removed from cart.%n", input[1]);
                    }
                    break;

                case "BuyItem":
                    this.orderService.buyItem();
                    break;
            }

        }
    }
}
