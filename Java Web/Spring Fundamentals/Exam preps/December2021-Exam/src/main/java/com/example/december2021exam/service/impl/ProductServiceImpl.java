package com.example.december2021exam.service.impl;

import com.example.december2021exam.model.entity.Category;
import com.example.december2021exam.model.entity.Product;
import com.example.december2021exam.model.entity.enums.CategoryNameEnum;
import com.example.december2021exam.model.service.CategoryServiceModel;
import com.example.december2021exam.model.service.ProductServiceModel;
import com.example.december2021exam.model.view.ProductViewModel;
import com.example.december2021exam.repository.ProductRepository;
import com.example.december2021exam.service.CategoryService;
import com.example.december2021exam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Category category = modelMapper.map(categoryService.findByName(productServiceModel.getCategory()), Category.class);
        productRepository
                .save(modelMapper
                        .map(productServiceModel, Product.class)
                        .setCategory(category));
    }

    @Override
    public List<ProductViewModel> findAllFoodProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryNameEnum.FOOD);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllDrinkProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryNameEnum.DRINK);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllHouseholdProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryNameEnum.HOUSEHOLD);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllOtherProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryNameEnum.OTHER);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal sumOfAllPrices() {
        return productRepository
                .findAll()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
