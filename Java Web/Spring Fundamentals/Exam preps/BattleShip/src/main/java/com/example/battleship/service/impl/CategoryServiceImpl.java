package com.example.battleship.service.impl;

import com.example.battleship.model.entity.Category;
import com.example.battleship.model.entity.enums.CategoryNameEnum;
import com.example.battleship.model.service.CategoryServiceModel;
import com.example.battleship.repository.CategoryRepository;
import com.example.battleship.service.CategoryService;
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
    public void seedServices() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(en -> {
                        Category category = new Category()
                                .setName(en);
                        switch (en) {
                            case BATTLE -> category.setDescription("Battle");
                            case CARGO -> category.setDescription("Cargo");
                            default -> category.setDescription("Patrol");
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryServiceModel findByCategoryNameEnum(CategoryNameEnum name) {
        return categoryRepository
                .findByName(name)
                .map(entity -> modelMapper.map(entity, CategoryServiceModel.class))
                .orElse(null);
    }
}
