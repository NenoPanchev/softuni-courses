package spring.fundamentals.springbootex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fundamentals.springbootex.models.dtos.ShopDto;
import spring.fundamentals.springbootex.models.entities.Product;
import spring.fundamentals.springbootex.models.entities.Shop;
import spring.fundamentals.springbootex.models.entities.Town;
import spring.fundamentals.springbootex.repositories.ShopRepository;
import spring.fundamentals.springbootex.services.ProductService;
import spring.fundamentals.springbootex.services.ShopService;
import spring.fundamentals.springbootex.services.TownService;
import spring.fundamentals.springbootex.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ProductService productService;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownService townService, ModelMapper modelMapper, ValidationUtil validationUtil, ProductService productService) {
        this.shopRepository = shopRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.productService = productService;
    }

    @Override
    public void seedShop(String[] input) {
        Shop shop = this.shopRepository.getByAddress(input[1]);
        Town town = this.townService.getByName(input[2]);
        ShopDto dto = new ShopDto(input[0], input[1], input[2]);
        if (this.validationUtil.isValid(dto) && shop == null && town != null) {
            shop = this.modelMapper.map(dto, Shop.class);
            shop.setTown(town);
            this.shopRepository.saveAndFlush(shop);
            System.out.println("Successfully added shop!");
        } else {
            this.validationUtil.getViolations(dto)
                    .stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }

    @Override
    public Shop getByName(String name) {
        return this.shopRepository.getByName(name);
    }

    @Transactional
    @Override
    public void distributeProductInShops(String productName, String[] arrayOfShops) {
        Product product = this.productService.getByName(productName);

        List<Shop> shops = Arrays.stream(arrayOfShops)
                .map(this::getByName)
                .collect(Collectors.toList());

        for (Shop shop : shops) {
            if (shop.getProducts() == null) {
                shop.setProducts(new HashSet<>());
            }
            if (product.getShops() == null) {
                product.setShops(new HashSet<>());
            }
            product.getShops().add(shop);
            shop.getProducts().add(product);
//            this.shopRepository.saveAndFlush(shop);
        }
//            shops
//                .forEach(shop -> {
//                    if (shop.getProducts() == null) {
//                        shop.setProducts(new HashSet<>());
//                    }
//                    shop.getProducts().add(product);
//                    this.shopRepository.saveAndFlush(shop);
//                });
        System.out.println("Successfully added product distribution!");
    }

    @Override
    public void getAllProductsByShopName(String shopName) {
        Shop shop = this.getByName(shopName);
        if (!shop.getProducts().isEmpty())
        shop.getProducts()
                .forEach(product -> System.out.printf("%s - %.2f $%n", product.getName(), product.getPrice()));
    }
}
