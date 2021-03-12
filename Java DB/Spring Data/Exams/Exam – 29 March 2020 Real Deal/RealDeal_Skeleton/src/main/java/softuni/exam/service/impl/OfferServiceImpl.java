package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.Offer;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.OfferSeedRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final XmlParser xmlParser;
    private final CarService carService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, XmlParser xmlParser, CarService carService, SellerService service, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.carService = carService;
        this.sellerService = service;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        OfferSeedRootDto rootDto = this.xmlParser.unmarshalFromFile(OFFERS_FILE_PATH, OfferSeedRootDto.class);


        rootDto.getOffers()
                .forEach(dto -> {
                    Car car = this.carService.getById(dto.getCar().getId());
                    Seller seller = this.sellerService.getById(dto.getSeller().getId());
                    Offer offer = this.offerRepository.getByDescriptionAndAddedOn(dto.getDescription(), dto.getAddedOn());

                    if (this.validationUtil.isValid(dto) && offer == null
                    && seller != null && car != null) {
                        offer = this.modelMapper.map(dto, Offer.class);
                        offer.setCar(car);
                        offer.setSeller(seller);
                        this.offerRepository.saveAndFlush(offer);
                        sb.append(String.format("Successfully imported offer - %s - %s",
                                offer.getAddedOn(), offer.isHasGoldStatus()));

                    } else {
                        sb.append("Invalid offer");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }
}
