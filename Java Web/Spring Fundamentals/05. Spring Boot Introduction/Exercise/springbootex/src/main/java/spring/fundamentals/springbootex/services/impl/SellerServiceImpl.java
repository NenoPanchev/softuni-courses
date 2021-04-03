package spring.fundamentals.springbootex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fundamentals.springbootex.models.dtos.SellerDto;
import spring.fundamentals.springbootex.models.entities.Seller;
import spring.fundamentals.springbootex.models.entities.Shop;
import spring.fundamentals.springbootex.repositories.SellerRepository;
import spring.fundamentals.springbootex.services.SellerService;
import spring.fundamentals.springbootex.services.ShopService;
import spring.fundamentals.springbootex.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final ShopService shopService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ShopService shopService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.shopService = shopService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSeller(String[] input) {
        SellerDto dto = new SellerDto(input[0], input[1], Integer.parseInt(input[2]), new BigDecimal(input[3]), input[4]);
        Shop shop = this.shopService.getByName(input[4]);

        if (this.validationUtil.isValid(dto) && shop != null) {
            Seller seller = this.modelMapper.map(dto, Seller.class);
            seller.setShop(shop);
            this.sellerRepository.saveAndFlush(seller);
            System.out.println("Successfully added seller!");

        } else {
            this.validationUtil.getViolations(dto).stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }

    @Override
    public void setManagerToASeller(String[] input, String[] managerNames) {
        Seller seller = this.sellerRepository.getByFirstNameAndLastName(input[0], input[1]);
        Seller manager = this.sellerRepository.getByFirstNameAndLastName(managerNames[0], managerNames[1]);
        seller.setManager(manager);
        this.sellerRepository.saveAndFlush(seller);
        System.out.println("Successfully added manager!");
    }

    @Override
    public void getAllSellersByShopName(String shopName) {
        this.sellerRepository.findAllByShopName(shopName)
                .forEach(seller -> System.out.println(seller.getFirstName() + " " + seller.getLastName()));
    }
}
