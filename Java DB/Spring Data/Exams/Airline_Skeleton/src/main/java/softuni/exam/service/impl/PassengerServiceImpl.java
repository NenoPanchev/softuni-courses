package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import static softuni.exam.constants.GlobalConstants.PASSENGERS_FILE_PATH;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays
                .stream(gson.fromJson(new FileReader(PASSENGERS_FILE_PATH), PassengerSeedDto[].class))
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && townService.townExists(dto.getTown());
                    sb
                            .append(isValid ? String.format("Successfully imported Passenger %s - %s",
                                    dto.getLastName(), dto.getEmail())
                                    : "Invalid Passenger")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Passenger.class)
                .setTown(townService.findByName(dto.getTown()).get()))
                .forEach(passengerRepository::save);
        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();
        passengerRepository
                .findAllOrderByTicketsCountDescAndEmail()
                .forEach(passenger -> sb
                .append(String.format("Passenger %s  %s%n" +
                        "\tEmail - %s%n" +
                        "\tPhone - %s%n" +
                        "\tNumber of tickets - %d%n",
                        passenger.getFirstName(), passenger.getLastName(),
                        passenger.getEmail(), passenger.getPhoneNumber(),
                        passenger.getTickets().size())));
        return sb.toString().trim();
    }

    @Override
    public boolean passengerExists(String email) {
        return passengerRepository.existsByEmail(email);
    }

    @Override
    public Optional<Passenger> findByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }
}
