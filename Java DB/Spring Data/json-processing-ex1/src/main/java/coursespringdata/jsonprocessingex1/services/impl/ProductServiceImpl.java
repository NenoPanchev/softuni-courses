package coursespringdata.jsonprocessingex1.services.impl;

import coursespringdata.jsonprocessingex1.models.dtos.ProductInRangeDto;
import coursespringdata.jsonprocessingex1.models.dtos.ProductSeedDto;
import coursespringdata.jsonprocessingex1.models.entities.Category;
import coursespringdata.jsonprocessingex1.models.entities.Product;
import coursespringdata.jsonprocessingex1.models.entities.User;
import coursespringdata.jsonprocessingex1.repositories.ProductRepository;
import coursespringdata.jsonprocessingex1.services.CategoryService;
import coursespringdata.jsonprocessingex1.services.ProductService;
import coursespringdata.jsonprocessingex1.services.UserService;
import coursespringdata.jsonprocessingex1.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedProducts(ProductSeedDto[] dtos) {
        Arrays.stream(dtos)
                .forEach(dto -> {
                    if (this.validationUtil.isValid(dto)) {
                        if (this.productRepository.getByName(dto.getName()) != null) {
                            System.out.printf("%s is already seeded.%n", dto.getName());
                        } else {
                            Product product = this.modelMapper.map(dto, Product.class);
                            product.setSeller(this.userService.getRandomUser());

                            int shouldProductHasBuyer = this.random.nextInt(2);
                            if (shouldProductHasBuyer == 1) {
                                while (true) {
                                    User buyer = this.userService.getRandomUser();
                                    if (!buyer.equals(product.getSeller())) {
                                        product.setBuyer(buyer);
                                        break;
                                    }
                                }
                            }
                            product.setCategories(getSetOfUpToThreeRandomCategories());
                            this.productRepository.saveAndFlush(product);
                        }
                    } else {
                        this.validationUtil.getViolations(dto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public List<ProductInRangeDto> getProductsIn500To1000RangeWithBuyerNullOrderedByPrice() {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream()
                .map(product -> {
                    ProductInRangeDto dto = this.modelMapper.map(product, ProductInRangeDto.class);
                    dto.setSeller(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getAvgProductPriceByCategoryId(Long id) {
        return this.productRepository.getAvgProductPriceByCategoryId(id);
    }


    @Override
    public BigDecimal getSumProductPriceByCategoryId(Long id) {
        return this.productRepository.getSumProductPriceByCategoryId(id);
    }

    private Set<Category> getSetOfUpToThreeRandomCategories() {
        Set<Category> set = new LinkedHashSet<>();
        int numberOfProductCategories = this.random.nextInt(3) + 1;

        for (int i = 0; i < numberOfProductCategories; i++) {
            Category category = categoryService.getRandomCategory();
            set.add(category);
        }
        return set;
    }

}
