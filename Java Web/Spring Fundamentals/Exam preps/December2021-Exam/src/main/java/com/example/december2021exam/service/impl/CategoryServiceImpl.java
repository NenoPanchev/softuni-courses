package com.example.december2021exam.service.impl;

import com.example.december2021exam.model.entity.Category;
import com.example.december2021exam.model.entity.enums.CategoryNameEnum;
import com.example.december2021exam.model.service.CategoryServiceModel;
import com.example.december2021exam.repository.CategoryRepository;
import com.example.december2021exam.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(en -> {
                        Category category = new Category()
                                .setName(en);
                        switch (en) {
                            case FOOD -> category.setDescription("Food");
                            case DRINK -> category.setDescription("Drink");
                            case HOUSEHOLD -> category.setDescription("Household");
                            default -> category.setDescription("Other");
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryServiceModel findByName(CategoryNameEnum name) {
        return categoryRepository
                .findByName(name)
                .map(entity -> modelMapper.map(entity, CategoryServiceModel.class))
                .orElse(null);
    }
}
