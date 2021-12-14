package com.example.battleships.service.impl;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.CategoryNameEnum;
import com.example.battleships.model.service.CategoryServiceModel;
import com.example.battleships.repository.CategoryRepository;
import com.example.battleships.service.CategoryService;
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
                    .forEach(categoryNameEnum -> {
                        Category category = new Category()
                                .setName(categoryNameEnum);
                        switch (categoryNameEnum){
                            case BATTLE -> category.setDescription("Battle");
                            case CARGO -> category.setDescription("Cargo");
                            case PATROL -> category.setDescription("Patrol");
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryServiceModel findByCategoryNameEnum(CategoryNameEnum category) {
        return modelMapper.map(categoryRepository.findByName(category).orElse(null),
                CategoryServiceModel.class);
    }
}
