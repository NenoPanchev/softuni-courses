package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.xml.TicketSeedRootDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
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

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PlaneService planeService;
    private final TownService townService;
    private final PassengerService passengerService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, PlaneService planeService, TownService townService, PassengerService passengerService) {
        this.ticketRepository = ticketRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.planeService = planeService;
        this.townService = townService;
        this.passengerService = passengerService;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        this.xmlParser
                .unmarshalFromFile(TICKETS_FILE_PATH, TicketSeedRootDto.class)
                .getTickets()
                .forEach(dto -> {
                    Town toTown = this.townService.getByName(dto.getToTown().getName());
                    Town fromTown = this.townService.getByName(dto.getFromTown().getName());
                    Plane plane = this.planeService.getByRegisterNumber(dto.getPlane().getRegisterNumber());
                    Ticket ticket = this.ticketRepository.getBySerialNumber(dto.getSerialNumber());
                    Passenger passenger = this.passengerService.getByEmail(dto.getPassenger().getEmail());
                    if (this.validationUtil.isValid(dto) && ticket == null
                            && toTown != null && fromTown != null && plane != null && passenger != null) {
                        ticket = this.modelMapper.map(dto, Ticket.class);
                        ticket.setToTown(toTown);
                        ticket.setFromTown(fromTown);
                        ticket.setPlane(plane);
                        ticket.setPassenger(passenger);
                        this.ticketRepository.saveAndFlush(ticket);
                        sb.append(String.format("Successfully imported Ticket %s - %s",
                                ticket.getFromTown().getName(), ticket.getToTown().getName()));

                    } else {
                        sb.append("Invalid Ticket");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }
}
