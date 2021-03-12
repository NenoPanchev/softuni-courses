package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.GlobalConstants.*;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        SellerSeedRootDto rootDto = this.xmlParser
                .unmarshalFromFile(SELLERS_FILE_PATH, SellerSeedRootDto.class);

        System.out.println();

        rootDto.getSellers()
                .forEach(dto -> {
                    Seller seller = this.sellerRepository.getByEmail(dto.getEmail());

                    if (this.validationUtil.isValid(dto) && seller == null) {
                        this.sellerRepository.saveAndFlush(this.modelMapper.map(dto, Seller.class));
                        sb.append(String.format("Successfully import seller %s - %s",
                                dto.getLastName(), dto.getEmail()));
                    } else {
                        sb.append("Invalid seller");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }

    @Override
    public Seller getById(Long id) {
        return this.sellerRepository.getById(id);
    }
}
