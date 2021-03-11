package course.springdata.xmlprocessingex1.services.impl;

import course.springdata.xmlprocessingex1.models.dtos.view.ProductInRangeDto;
import course.springdata.xmlprocessingex1.models.dtos.ProductSeedDto;
import course.springdata.xmlprocessingex1.models.dtos.view.ProductViewInRangeRootDto;
import course.springdata.xmlprocessingex1.models.entities.Category;
import course.springdata.xmlprocessingex1.models.entities.Product;
import course.springdata.xmlprocessingex1.models.entities.User;
import course.springdata.xmlprocessingex1.repositories.ProductRepository;
import course.springdata.xmlprocessingex1.services.CategoryService;
import course.springdata.xmlprocessingex1.services.ProductService;
import course.springdata.xmlprocessingex1.services.UserService;
import course.springdata.xmlprocessingex1.utils.ValidationUtil;
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
    public void seedProducts(List<ProductSeedDto> dtos) {
        if (this.productRepository.count() > 0) {
            return;
        }

        dtos
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
    public ProductViewInRangeRootDto getProductsIn500To1000RangeWithBuyerNullOrderedByPrice() {
        List<ProductInRangeDto> dtos = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream()
                .map(product -> {
                    ProductInRangeDto dto = this.modelMapper.map(product, ProductInRangeDto.class);
                    dto.setSeller(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
                    return dto;
                })
                .collect(Collectors.toList());
        ProductViewInRangeRootDto rootDto = new ProductViewInRangeRootDto();
        rootDto.setProducts(dtos);
        return rootDto;
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
