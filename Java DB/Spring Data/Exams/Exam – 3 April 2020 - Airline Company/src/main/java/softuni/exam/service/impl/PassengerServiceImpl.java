package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.json.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.awt.font.TextHitInfo;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson
                .fromJson(new FileReader(PASSENGERS_FILE_PATH), PassengerSeedDto[].class))
                .forEach(dto -> {
                    Town town = this.townService.getByName(dto.getTown());
                    Passenger passenger = this.passengerRepository.getByEmail(dto.getEmail());

                    if (this.validationUtil.isValid(dto) && town != null
                            && passenger == null) {
                        passenger = this.modelMapper.map(dto, Passenger.class);
                        passenger.setTown(town);
                        this.passengerRepository.saveAndFlush(passenger);
                        sb.append(String.format("Successfully imported Passenger %s - %s",
                                passenger.getLastName(), passenger.getEmail()));
                    } else {
                        sb.append("Invalid Passenger");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();
        this.passengerRepository.getPassengersOrderByTicketsCountDescendingThenByEmail()
                .forEach(passenger -> sb.append(String.format("Passenger %s %s%n" +
                        "\tEmail - %s%n" +
                        "\tPhone - %s%n" +
                        "\tNumber of tickets - %d%n%n",
                        passenger.getFirstName(), passenger.getLastName(),
                        passenger.getEmail(),
                        passenger.getPhoneNumber(),
                        passenger.getTickets().size())));

        return sb.toString();
    }

    @Override
    public Passenger getByEmail(String email) {
        return this.passengerRepository.getByEmail(email);
    }
}
