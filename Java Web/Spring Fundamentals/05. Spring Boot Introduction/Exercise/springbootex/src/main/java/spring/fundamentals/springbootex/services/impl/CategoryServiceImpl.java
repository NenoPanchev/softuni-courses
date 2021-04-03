package spring.fundamentals.springbootex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fundamentals.springbootex.models.dtos.CategoryDto;
import spring.fundamentals.springbootex.models.entities.Category;
import spring.fundamentals.springbootex.repositories.CategoryRepository;
import spring.fundamentals.springbootex.services.CategoryService;
import spring.fundamentals.springbootex.utils.ValidationUtil;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategory(String categoryName) {
        CategoryDto dto = new CategoryDto(categoryName);
        if (this.validationUtil.isValid(dto) && this.categoryRepository.getByName(categoryName) == null) {
            this.categoryRepository.saveAndFlush(this.modelMapper.map(dto, Category.class));
            System.out.println("Successfully added category!");
            System.out.println("=================================");
        } else {
            System.out.println("Name must be minimum two characters!");
        }
    }

    @Override
    public Category getByName(String name) {
        return this.categoryRepository.getByName(name);
    }
}
