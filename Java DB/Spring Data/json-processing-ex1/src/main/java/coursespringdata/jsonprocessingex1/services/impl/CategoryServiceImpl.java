package coursespringdata.jsonprocessingex1.services.impl;

import coursespringdata.jsonprocessingex1.models.dtos.CategoryByProductsDto;
import coursespringdata.jsonprocessingex1.models.dtos.CategorySeedDto;
import coursespringdata.jsonprocessingex1.models.entities.Category;
import coursespringdata.jsonprocessingex1.models.entities.Product;
import coursespringdata.jsonprocessingex1.repositories.CategoryRepository;
import coursespringdata.jsonprocessingex1.services.CategoryService;
import coursespringdata.jsonprocessingex1.services.ProductService;
import coursespringdata.jsonprocessingex1.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        Arrays.stream(categorySeedDtos)
                .forEach(categorySeedDto -> {
                    if (this.validationUtil.isValid(categorySeedDto)) {
                        if (this.categoryRepository.findByName(categorySeedDto.getName()) != null) {
                            System.out.println("This category is already seeded.");
                        } else {
                            this.categoryRepository.saveAndFlush(this.modelMapper.map(categorySeedDto, Category.class));
                        }
                    } else {
                        this.validationUtil.getViolations(categorySeedDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public Category getRandomCategory() {
        long randomId = this.random.nextInt((int) this.categoryRepository.count()) + 1;
        return this.categoryRepository.getById(randomId);
    }

    @Transactional
    @Override
    public List<Category> getAllCategoriesOrderedByProductCount() {
        return this.categoryRepository.findAllOrderedByCountOfProducts();
    }

    private BigDecimal sum(List<BigDecimal> bigDecimals) {
        return bigDecimals.stream()
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal average(List<BigDecimal> bigDecimals, RoundingMode roundingMode) {
            return sum(bigDecimals).divide(new BigDecimal(bigDecimals.size()), roundingMode);
    }
}
