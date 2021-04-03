package spring.fundamentals.springbootex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fundamentals.springbootex.models.dtos.ProductDto;
import spring.fundamentals.springbootex.models.entities.Category;
import spring.fundamentals.springbootex.models.entities.Product;
import spring.fundamentals.springbootex.repositories.ProductRepository;
import spring.fundamentals.springbootex.services.CategoryService;
import spring.fundamentals.springbootex.services.ProductService;
import spring.fundamentals.springbootex.utils.ValidationUtil;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void seedProduct(String[] input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(input[2], formatter);
        Category category = this.categoryService.getByName(input[3]);
        ProductDto dto = new ProductDto(input[0], new BigDecimal(input[1]), date, input[3]);

        if (this.validationUtil.isValid(dto)) {
            Product product = this.modelMapper.map(dto, Product.class);
            product.setCategory(category);
            this.productRepository.saveAndFlush(product);
            System.out.println("Successfully added product!");

        } else {
            this.validationUtil.getViolations(date)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
    }

    @Override
    public Product getByName(String name) {
        return this.productRepository.getByName(name);
    }

}
