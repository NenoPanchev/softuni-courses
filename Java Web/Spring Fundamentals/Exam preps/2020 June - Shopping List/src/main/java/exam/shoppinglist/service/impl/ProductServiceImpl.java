package exam.shoppinglist.service.impl;

import exam.shoppinglist.model.entity.Category;
import exam.shoppinglist.model.entity.CategoryName;
import exam.shoppinglist.model.entity.Product;
import exam.shoppinglist.model.service.CategoryServiceModel;
import exam.shoppinglist.model.service.ProductServiceModel;
import exam.shoppinglist.model.view.ProductViewModel;
import exam.shoppinglist.repository.ProductRepository;
import exam.shoppinglist.service.CategoryService;
import exam.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        CategoryServiceModel csm = this.categoryService.findByName(productServiceModel.getCategory().getName());
        Category category = this.modelMapper.map(csm, Category.class);
        product.setCategory(category);
        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductViewModel> findAllFoodProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryName.FOOD);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllDrinkProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryName.DRINK);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllHouseholdProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryName.HOUSEHOLD);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductViewModel> findAllOtherProducts() {
        CategoryServiceModel csm = this.categoryService.findByName(CategoryName.OTHER);
        Category category = this.modelMapper.map(csm, Category.class);
        return this.productRepository.findAllByCategory(category)
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal sumOfAllPrices() {
        return this.productRepository.findAll()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.productRepository.deleteAll();
    }

}
