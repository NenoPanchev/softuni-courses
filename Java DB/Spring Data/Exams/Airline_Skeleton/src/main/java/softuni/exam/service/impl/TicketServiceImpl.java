package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.xml.TicketSeedRootDto;
import softuni.exam.models.entities.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.TICKETS_FILE_PATH;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final TownService townService;
    private final PlaneService planeService;
    private final PassengerService passengerService;
    private final ValidationUtil validationUtil;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper, XmlParser xmlParser, TownService townService, PlaneService planeService, PassengerService passengerService, ValidationUtil validationUtil) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.planeService = planeService;
        this.passengerService = passengerService;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser
                .unmarshalFromFile(TICKETS_FILE_PATH, TicketSeedRootDto.class)
                .getTickets()
                .stream()
                .filter(dto -> {
                    boolean isValid = validationUtil.isValid(dto)
                            && !ticketExists(dto.getSerialNumber())
                            && townService.townExists(dto.getFromTown().getName())
                            && townService.townExists(dto.getToTown().getName())
                            && planeService.planeExists(dto.getPlane().getRegisterNumber())
                            && passengerService.passengerExists(dto.getPassenger().getEmail());
                    sb
                            .append(isValid ? String.format("Successfully imported Ticket %s - %s",
                                    dto.getFromTown().getName(), dto.getToTown().getName())
                                    : "Invalid Ticket")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(dto -> modelMapper.map(dto, Ticket.class)
                .setFromTown(townService.findByName(dto.getFromTown().getName()).get())
                .setToTown(townService.findByName(dto.getToTown().getName()).get())
                .setPlane(planeService.findByRegisterNumber(dto.getPlane().getRegisterNumber()).get())
                .setPassenger(passengerService.findByEmail(dto.getPassenger().getEmail()).get()))
                .forEach(ticketRepository::save);

        return sb.toString().trim();
    }

    @Override
    public boolean ticketExists(String serialNumber) {
        return ticketRepository.existsBySerialNumber(serialNumber);
    }

}
